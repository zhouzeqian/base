package com.hzlh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Maps;

public class PropertiesUtil {

	public static Map<String,String> getProperties(String fileName){
		
		Properties properties=new Properties();
		Map<String,String> map=Maps.newHashMap();
		InputStream in=PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(in);
			
			for(Object key:properties.keySet()){
				
				map.put(key.toString(), properties.getProperty(key.toString()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	
	public static void main(String[] args){
		Map<String,String> map=getProperties("jdbc.properties");
		for(String key:map.keySet()){
			System.out.println(key+"---"+map.get(key));
		}
	}
}
