package com.llc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.llc.entity.User;
import com.llc.redis.RedisClientTemplate;
import com.llc.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserService userService;
	@Resource
	RedisClientTemplate redisClient;

	@RequestMapping("login")
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("talk");
		User user = userService.findUser(username, password);
		request.getSession().setAttribute("uid", user.getId());
		request.getSession().setAttribute("name", user.getUsername());
		// 存在redis里面
		if (redisClient.get(user.getId().toString()) == null)
			redisClient.set(user.getId().toString(), JSON.toJSONString(user));
		mav.addObject("uid", user.getId());
		mav.addObject("name", user.getUsername());
		mav.setViewName("talk");
		return mav;
	}
}
