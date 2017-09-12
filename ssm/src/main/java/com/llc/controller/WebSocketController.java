package com.llc.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;
import com.llc.entity.Message;
import com.llc.redis.RedisClientTemplate;
import com.llc.websocket.SystemWebSocketHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/ws")
@Api(description = "websocket即时通讯")
public class WebSocketController {

	@Resource
	SystemWebSocketHandler handler;
	@Resource
	RedisClientTemplate redisClient;

	// 跳转到交谈聊天页面
	@RequestMapping(value = "talk", method = RequestMethod.GET)
	public ModelAndView talk() {
		return new ModelAndView("talk");
	}

	// 推送消息给指定用户
	@ResponseBody
	@RequestMapping(value = "push", method = RequestMethod.POST)
	@ApiOperation(value = "推送消息给指定用户", notes = "推送消息给指定用户")
	public void push(@ApiParam(value = "自己ID") @RequestParam(value = "mid") Integer mid,
			@ApiParam(value = "对方ID") @RequestParam(value = "uid") Integer uid,
			@ApiParam(value = "消息内容") @RequestParam(value = "text") String text) {

		Message msg = new Message();
		msg.setFromId(mid);
		msg.setFromName(JSON.parseObject(redisClient.get(mid.toString())).getString("username"));
		msg.setMsgContent(text);
		msg.setToId(uid);
		msg.setToName(JSON.parseObject(redisClient.get(mid.toString())).getString("username"));
		msg.setSendTime(new Date());
		msg.setMsgType(0);
		try {
			handler.sendMessageToUser(uid,
					new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
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
	@ApiOperation(value = "推送给所有用户", notes = "推送给所有用户")
	public void broadcast(@ApiParam(value = "消息内容") @RequestParam(value = "text") String text) throws IOException {
		Message msg = new Message();
		msg.setFromId(-1);
		msg.setFromName("系统");
		msg.setMsgContent(text);
		msg.setToId(0);
		msg.setToName("所有用户");
		msg.setSendTime(new Date());
		msg.setMsgType(1);
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

}