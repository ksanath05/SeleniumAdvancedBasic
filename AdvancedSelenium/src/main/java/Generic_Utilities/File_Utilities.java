package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utilities {

	public String getKeyAndValueData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		 String value = pro.getProperty(key);
		 return value;
	}
	
	
}
