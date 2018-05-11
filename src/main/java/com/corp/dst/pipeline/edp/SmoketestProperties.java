import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Smoketest whitelist configuration properties
 * 
 */
@ConfigurationProperties()
public class SmoketestProperties implements InitializingBean {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	/**
	 * Fetch Size / Commit Interval
	 */
	private int fetchsize;
	private int recordscount;
	private String datasourcename;
	private String databasename;
	private String schemaname;
	private String table;
	private String mode;

	public int getFetchsize() {
		return fetchsize;
	}

	public void setFetchsize(int fetchsize) {
		this.fetchsize = fetchsize;
	}

	public int getRecordscount() {
		return recordscount;
	}

	public void setRecordscount(int recordscount) {
		this.recordscount = recordscount;
	}

	public String getDatasourcename() {
		return datasourcename;
	}

	public void setDatasourcename(String datasourcename) {
		this.datasourcename = datasourcename;
	}

	public String getDatabasename() {
		return databasename;
	}

	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}

	public String getSchemaname() {
		return schemaname;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getMode() {
		return mode;
	}

	@Override
	public String toString() {
		return "SmoketestProperties [LOG=" + LOG + ", fetchsize=" + fetchsize + ", recordscount=" + recordscount
				+ ", datasourcename=" + datasourcename + ", databasename=" + databasename + ", schemaname=" + schemaname
				+ ", table=" + table + ", mode=" + mode + "]";
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		LOG.info(this.toString());
		LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");		
	}
}
