package com.llc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;

@RestController
@RequestMapping("test")
public class TestController {

	@RequestMapping("error")
	public BaseResult<Integer> error(String str){
		
		BaseResult<Integer> br=new BaseResult<Integer>();
		br.setCode(1);
		br.setMsg("字符串转数字成功");
		br.setObj(Integer.valueOf(str));
		return br;
		
	}
}
