package com.kxll.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kxll.base.MultiThread;
import com.kxll.util.MultiThreadUtil;

@RestController
@RequestMapping("multiThread")
public class MultiThreadController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	MultiThreadUtil multiThreadUtil;

	@RequestMapping("test")
	public void test() {
		for (int i = 0; i < 25; i++) {
			MultiThread mt = new MultiThread("当前线程:"+i);
			multiThreadUtil.printMessages(mt, i);
		}
		System.out.println("主线程");
	}
}
