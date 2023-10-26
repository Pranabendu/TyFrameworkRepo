package hms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String fetchDataFromProperty(String key){
		
		FileInputStream fis = null;
		Properties pObj = null;
		try {
			// Open the properties file
			fis = new FileInputStream("./files/propertyfile.properties");
			pObj = new Properties();

			// Load the properties from the input stream
			pObj.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Get the value associated with the given key
		String value = pObj.getProperty(key);
		return value;
		
	}
}