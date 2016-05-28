package com.hzlh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getProperties(String fileName,String key){
		
		Properties properties=new Properties();
		
		InputStream in=PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
		
	}
}
