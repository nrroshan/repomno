package genericScripts;

import java.io.FileInputStream;
import java.util.Properties;

public class HandlingDataFromPropertyFile {
	static FileInputStream fis;
	static Properties p;
	public static String getData(String path, String propertyName)
	{
		try {
			fis = new FileInputStream(path);
			p = new Properties();
			p.load(fis);
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
		return p.getProperty(propertyName);
	}
}
