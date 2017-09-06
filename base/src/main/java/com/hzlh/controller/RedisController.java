package com.hzlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzlh.base.ResultBase;
import com.hzlh.service.RedisService;
import com.hzlh.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description="redis增删改查")
@RequestMapping(value="/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="赋值",notes="赋值")
	@RequestMapping(value="setVal",method=RequestMethod.POST)
	
	public ResultBase<String> setValue(@ApiParam(name="key",value="key") @RequestParam(value="key") String key,
			@ApiParam(name="value",value="value") @RequestParam(value="value") String value){
		return redisService.setValue(key, value);
	}
	@ApiOperation(value="取值",notes="取值")
	@RequestMapping(value="getVal",method=RequestMethod.POST)
	
	public ResultBase<String> getValue(@ApiParam(name="key",value="key") @RequestParam(value="key") String key){
		
		return redisService.getValue(key);
	}
	@ApiOperation(value="通过key删除value",notes="通过key删除value")
	@RequestMapping(value="del",method=RequestMethod.POST)
	
	public ResultBase<Long> del(@ApiParam(name="key",value="key") @RequestParam(value="key") String key){
		return redisService.del(key);
	}
	
	@ApiOperation(value="对象赋值",notes="对象赋值")
	@RequestMapping(value="setObj",method=RequestMethod.POST)
	
	public ResultBase<Object> setObj(@ApiParam(name="key",value="key") @RequestParam(value="key") String key,
			@ApiParam(name="id",value="系统id") @RequestParam(value="id") Integer id){
		return redisService.setObj(key, this.userService.findById(id));
	}
	@ApiOperation(value="对象取值",notes="对象取值")
	@RequestMapping(value="getObj",method=RequestMethod.POST)
	
	public ResultBase<Object> getObj(@ApiParam(name="key",value="key") @RequestParam(value="key") String key){
		return redisService.getObj(key);
	}
}
