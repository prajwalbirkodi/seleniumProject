package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Logger logger = LogManager.getLogger();

	private static Properties prop = new Properties();
	public final static String CONFIG_DATA_FILE_NAME = "config.properties";

	static {
	    try {
	        String configFileResourcePath = "config/";
	        InputStream configResourceInputStream = ConfigReader.class
	                .getClassLoader()
	                .getResourceAsStream(configFileResourcePath + CONFIG_DATA_FILE_NAME);

	        if (configResourceInputStream == null) {
	            throw new RuntimeException("config.properties not found in resources/config/");
	        }

	        prop.load(configResourceInputStream);

	    } catch (Exception e) {
	        logger.error(
	                "Unexpected error occurred when loading configuration. {}",
	                e.getMessage());
	    }
	}

	public static String getProperty(String key) {

		return prop.getProperty(key.trim());
	}
}
