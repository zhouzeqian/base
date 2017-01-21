package com.llc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.base.BaseResult;
import com.llc.entity.User;
import com.llc.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Resource
	UserService userService;

	@RequestMapping("find")
	public BaseResult<List<User>> find() {

		return userService.find();
	}
}
