package com.llc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;
import com.llc.entity.User;
import com.llc.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
@Api(description="用户操作")
public class UserController {
	@Resource
	UserService userService;

	@RequestMapping(value="find",method=RequestMethod.GET)
	@ApiOperation(value="用户列表")
	public BaseResult<List<User>> find() {
		return userService.find();
	}
}
