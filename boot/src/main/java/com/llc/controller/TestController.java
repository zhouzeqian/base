package com.llc.controller;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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
	@Resource
	RedissonClient redisson;

	static int num=0;
	@ApiOperation(value = "测试")
	@RequestMapping(value = "helloWorld", method = RequestMethod.POST)
	public BaseResult<User> helloWorld(@ApiParam(required = true, name = "user", value = "用户信息") User user) {
		BaseResult<User> br = new BaseResult<User>();
		br.setCode("SUCCESS");
		br.setMsg("返回成功");
		br.setObj(user);
		return br;
	}
	
	@RequestMapping(value = "lockTest")
	public BaseResult<Integer> lockTest() {
		BaseResult<Integer> br = new BaseResult<Integer>();
		br.setCode("SUCCESS");
		br.setMsg("返回成功");
		RLock lock = redisson.getLock("lock_test");
		try {
			lock.tryLock(100, 10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		br.setObj(++num);
		lock.unlock();
		return br;
	}
}
