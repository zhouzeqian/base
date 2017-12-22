package com.llc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;
import com.llc.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("test")
@Api(description = "测试")
public class TestController {

	@ApiOperation(value = "测试")
	@RequestMapping(value = "helloWorld", method = RequestMethod.POST)
	public BaseResult<User> helloWorld(@ApiParam(required = true, name = "user", value = "用户信息") User user) {
		BaseResult<User> br = new BaseResult<User>();
		br.setCode("SUCCESS");
		br.setMsg("返回成功");
		br.setObj(user);
		return br;
	}
}
