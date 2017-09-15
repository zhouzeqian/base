package com.llc.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			// 捕获密码错误异常
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "密码错误!");
			return mv;
		} catch (UnknownAccountException uae) {
			// 捕获未知用户名异常
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "用户名错误!");
			return mv;
		} catch (ExcessiveAttemptsException eae) {
			// 捕获错误登录过多的异常
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "登录次数过多");
			return mv;
		}
		User user = userService.findByName(username);
		user.setLastLoginTime(new Date());
		userService.update(user);
		request.getSession().setAttribute("uid", user.getId());
		request.getSession().setAttribute("name", user.getUsername());
		// 存在redis里面
		if (redisClient.get(user.getId().toString()) == null)
			redisClient.set(user.getId().toString(), JSON.toJSONString(user));
		ModelAndView mav = new ModelAndView("view/talk");
		mav.addObject("uid", user.getId());
		mav.addObject("name", user.getUsername());
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)    
    public ModelAndView logout() {  
        Subject currentUser = SecurityUtils.getSubject();  
        currentUser.logout();  
        ModelAndView mav = new ModelAndView("login");
        return mav;  
    }  

	@RequestMapping(value = "delete")
	public Integer delete(Integer id) {
		return userService.delete(id);
	}

	@RequestMapping(value = "find")
	public User find(Integer id) {
		return userService.find(id);
	}

	@RequestMapping(value = "update")
	public Integer update(User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "add")
	public Integer add(User user) {
		return userService.add(user);
	}
}
