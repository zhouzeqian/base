package com.llc.test;

import org.springframework.core.io.DefaultResourceLoader;

public class PathTest {
    public static void main(String[] args) {
        DefaultResourceLoader resource=new DefaultResourceLoader();
        System.out.println(resource.getResource("mybatis-config.xml").exists());
    }
}
