package genericScripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class HandlingDataFromPropertyFile {
	static FileInputStream fis;
	static FileOutputStream fos;
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
	

	public static void setData(String path, LinkedHashMap<String, String> map)
	{
		try {
			fos = new FileOutputStream(path);
			p = new Properties();
			
			Set<Entry<String, String>> entrySet = map.entrySet();
			for (Entry<String, String> entry : entrySet) {
				p.setProperty(entry.getKey(), entry.getValue());
			}
			p.store(fos, "User details");
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
