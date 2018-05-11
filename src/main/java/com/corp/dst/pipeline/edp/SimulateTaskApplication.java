import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({SmoketestProperties.class})
@EnableBatchProcessing
@EnableTask
public class SimulateTaskApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunnerImpl();
	}	

	public static void main(String[] args) {
		SpringApplication.run(SimulateTaskApplication.class, args);
	}
	
	public static class ApplicationRunnerImpl implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Inside ApplicationRunnerImpl.run()");
		}
	}
	
	  /**
     * A commandline runner that prints arguments.
     */
    public class CommandLineRunnerImpl implements CommandLineRunner {

        @Autowired
        private SmoketestProperties config;

        @Override
        public void run(String... strings) throws Exception {
			System.out.println(">>>>>>>>>>>>>>>>> Inside CommandLineRunnerImpl.run()");
			System.out.println(">>>>>>>>>>>>>>>>> config.toString()" +  config.toString());			
        }
   }	
}