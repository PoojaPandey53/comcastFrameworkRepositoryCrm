package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of method to read the data from property key
 */

public class PropertyFileUtility {

	/**
	 * this method is used to read data from property file provided key 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
        Properties prop = new Properties();
        prop.load(fis);
      String value = prop.getProperty(key);
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      return value;
	}

}
