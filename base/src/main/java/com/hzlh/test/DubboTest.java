package com.hzlh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzlh.service.DubboService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-consumer.xml")
public class DubboTest {
	@Autowired
	private DubboService dubboservice;
	@Test
	public void test(){
		System.out.println(this.dubboservice.getNow());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
