package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertyFileHandler {

	Properties properties = new Properties();
	
	String filePath;
	
	public PropertyFileHandler(String filePath) {
		this.filePath = filePath;
	}
	
	public void writeData(HashMap<String, String> data) throws IOException {
		
		Set<String> keyset = data.keySet();

		for (String key : keyset) {
			properties.setProperty(key, data.get(key));
		}

		FileOutputStream file = new FileOutputStream(filePath);

		properties.store(file, "Sample test-data of customers in property file");

	}

	public String readProperty(String key) throws IOException {

		String value = "";
		
		try(FileInputStream file = new FileInputStream(filePath)){
			
			properties.load(file); //load the file if it exists
			
			value = properties.getProperty(key); //read the key -> value
			
			
		}

		return value;
	}

	public void deleteData(String key) throws IOException {

		try(FileInputStream file = new FileInputStream(filePath)) {
		
			properties.load(file);
			
			properties.remove(key);

			
		}

		// Save updated properties to file
	    try (FileOutputStream outFile = new FileOutputStream(filePath)) {
	    
	    	properties.store(outFile, "Updated after deleting key: " + key);
	    
	    }
		
	}

}
