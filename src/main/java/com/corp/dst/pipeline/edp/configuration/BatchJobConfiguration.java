import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.configuration.TaskConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ImportResource("/scdf-smoketest.xml")
public class BatchJobConfiguration {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("taskRepoDS")
	private DataSource dataSource;
	
	@Bean
	public TaskConfigurer taskConfigurer() {
		return new DefaultTaskConfigurer(dataSource);
	}

	@Bean
	public DefaultBatchConfigurer batchConfigurer() {
		return new DefaultBatchConfigurer(this.dataSource);
	}
	
	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setTransactionManager(transactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
		factory.setDataSource(this.dataSource);
		factory.setDatabaseType("MYSQL");
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}	
}