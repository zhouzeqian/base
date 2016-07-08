package com.hzlh.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.hzlh.entity.User;

@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {
	
	@RequestMapping("/list")
	public ModelAndView getUserList(ModelAndView mav){
		List<User> userList=Lists.newArrayList();
		for(long i=0;i<10;i++){
			User user=new User();
			user.setId(i);
			user.setArchived(true);
			user.setCreateTime(new Date());
			user.setEmail(i+"@aliyun.com");
			user.setUsername("hz"+i);
			userList.add(user);
		}
		mav.addObject("userList", userList);
		mav.setViewName("freemarker");
		return mav;
	}
}
