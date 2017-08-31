package com.llc.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.entity.Message;
import com.llc.service.FeignService;

@RestController
@RequestMapping("feign")
public class FeignController {

	@Resource
	FeignService feignService;

	@RequestMapping(value = "getMsg")
	public Message getMsg(Message msg) {
		return feignService.getMsg(msg);
	}
	
	@RequestMapping("hi")
	public String home(String name) {
		return feignService.home(name);
	};
}
