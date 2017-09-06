package com.hzlh.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.google.gson.GsonBuilder;
import com.hzlh.entity.Message;
import com.hzlh.entity.User;
import com.hzlh.websocket.MyWebSocketHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/msg")
@Api(description="websocket即时通讯")
public class MsgController {

	@Resource
	MyWebSocketHandler handler;

	Map<Long, User> users = new HashMap<Long, User>();

	// 模拟一些数据
	@ModelAttribute
	public void setReqAndRes() {
		User u1 = new User();
		u1.setId(1L);
		u1.setUsername("张三");
		users.put(u1.getId(), u1);

		User u2 = new User();
		u2.setId(2L);
		u2.setUsername("李四");
		users.put(u2.getId(), u2);
		
		User u3 = new User();
		u3.setId(3L);
		u3.setUsername("王五");
		users.put(u3.getId(), u3);

	}

	// 用户登录 
	//数据可以用redis存储
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ApiOperation(value="登录",notes="登录")
	public ModelAndView doLogin(User user, HttpServletRequest request) {
		request.getSession().setAttribute("uid", user.getId());
		request.getSession().setAttribute("name", users.get(user.getId()).getUsername());
		ModelAndView mav=new ModelAndView();
		mav.addObject("uid", user.getId());
		mav.addObject("name", user.getUsername());
		mav.setViewName("talk");
		return mav;
	}

	// 跳转到交谈聊天页面
	@RequestMapping(value = "talk", method = RequestMethod.GET)
	public ModelAndView talk() {
		return new ModelAndView("talk");
	}
	
	// 推送消息给指定用户
		@ResponseBody
		@RequestMapping(value = "push", method = RequestMethod.POST)
		@ApiOperation(value="推送消息给指定用户",notes="推送消息给指定用户")
		public void push(
				@ApiParam(value="自己ID") @RequestParam(value="mid") Long mid,
				@ApiParam(value="对方ID") @RequestParam(value="uid") Long uid,
				@ApiParam(value="消息内容") @RequestParam(value="text") String text) {
	
			Message msg = new Message();
			msg.setDate(new Date());
			msg.setFrom(mid);
			msg.setFromName(users.get(mid).getUsername());
			msg.setTo(uid);
			msg.setText(text);
			try {
				handler.sendMessageToUser(uid, new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// 跳转到发布广播页面
	@RequestMapping(value = "broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {
		return new ModelAndView("broadcast");
	}

	// 发布系统广播（群发）
	@ResponseBody
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	@ApiOperation(value="推送给所有用户",notes="推送给所有用户")
	public void broadcast(
			@ApiParam(value="消息内容") @RequestParam(value="text") String text) throws IOException {
		Message msg = new Message();
		msg.setDate(new Date());
		msg.setFrom(-1L);
		msg.setFromName("系统广播");
		msg.setTo(0L);
		msg.setText(text);
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

}