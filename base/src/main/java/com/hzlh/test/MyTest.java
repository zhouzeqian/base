package com.hzlh.test;

import com.hzlh.util.PropertiesUtil;

public class MyTest {
	

	public static void main(String[] args){
		System.out.println(PropertiesUtil.getProperties("jms.properties", "jms.url"));
		
	}
}
