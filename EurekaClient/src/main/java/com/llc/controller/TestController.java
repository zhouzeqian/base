package com.llc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llc.entity.Message;

@RestController
@RequestMapping("/test")
public class TestController {


	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + port;
	}

	
	@RequestMapping("/getMsg")
	public Message getMsg(@RequestBody Message msg) {
		return msg;
	}
}
