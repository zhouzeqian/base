package com.hzlh.test;

import java.util.Properties;

public class MyTest {
	

	public static void main(String[] args){
		Properties prop = new Properties();
		try {
			prop.load(new MyTest().getClass().getResourceAsStream("/jdbc.properties"));
			System.out.println(prop.getProperty("jdbc.url"));
			//System.out.println(new MyTest().getClass().getResourceAsStream("/jdbc.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
