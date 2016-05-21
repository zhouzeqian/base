package com.hzlh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzlh.base.ResultBase;
import com.hzlh.base.SystemDefined;
import com.hzlh.mq.producer.QueueSender;
import com.hzlh.mq.producer.TopicSender;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@Api(value="ActivemqController",description="消息测试")
@RequestMapping("/jms")
public class ActivemqController {
	@Resource
	private QueueSender queueSender;
	@Resource
	private TopicSender topicSender;
	
	@RequestMapping(value="/sengQueue",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="发送Queue消息",notes="发送Queue消息")
	public ResultBase<String> sendQueue(
			@ApiParam(name="msg",value="发送到Queue的消息") @RequestParam(value="msg") String msg){
		this.queueSender.sendQueue("testqueue", msg);
		ResultBase<String> rb=new ResultBase<String>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("发送Queue消息成功！");
		rb.setObj(msg);
		return rb;
		
	}
	@RequestMapping(value="/sengTopic",method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="发送Topic消息",notes="发送Topic消息")
	public ResultBase<String> sendTopic(
			@ApiParam(name="msg",value="发送到Topic的消息") @RequestParam(value="msg") String msg){
		this.topicSender.sendTopic("testtopic", msg);
		ResultBase<String> rb=new ResultBase<String>();
		rb.setCode(SystemDefined.ResultCode.SUCCESS);
		rb.setMsg("发送Topic消息成功！");
		rb.setObj(msg);
		return rb;
		
	}
}
