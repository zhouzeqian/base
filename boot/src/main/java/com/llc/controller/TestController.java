package com.llc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;

@RestController
@RequestMapping("test")
public class TestController {

	@RequestMapping("helloWorld")
	public BaseResult<String> helloWorld(){
		BaseResult<String> br=new BaseResult<String>();
		br.setCode("SUCCESS");
		br.setMsg("返回成功");
		br.setObj("Hello World!");
		return br;
	}
}
