package dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {
	
	private Properties properties;
	private final String propertyFilePath = ".//configs/configuration.properties";
	
	public PropertyFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at:"+propertyFilePath);
		}
	}
	
	public String getValueFromPropertyFile(String key) {
		String value = properties.getProperty(key);
		if(value != null)
			return value;
		else
			throw new RuntimeException("url not specified in the properties file");	
	}
	
	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException("testDataResourcePath not specified in the properties file");
	}

}
