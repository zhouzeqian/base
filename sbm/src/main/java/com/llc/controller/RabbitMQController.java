package com.llc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llc.rabbitmq.RabbitMQSender;

@RequestMapping("rabbitmq")
@RestController
public class RabbitMQController {
	@Autowired
    RabbitMQSender rabbitMQSender;
	
	@RequestMapping("send")
	public void send(String msg) {
		rabbitMQSender.sendMsg(msg);
	}
}
