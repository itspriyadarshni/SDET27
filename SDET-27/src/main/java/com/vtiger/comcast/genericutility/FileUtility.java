package com.vtiger.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	/**
	 * its used to read the data from properties File based on Key which you pass as an argument
	 * @param key
	 * @return String
	 * @throws Exception
	 */
	
	public String getPropertyKeyValue(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./Data/Property/logindetails.properties");
		Properties p=new Properties();
		p.load(fis);
		String keyvalue = p.getProperty(key);
		return keyvalue;
	}
}
