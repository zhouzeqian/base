package com.llc.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.llc.config.RabbitMQConfig;
@Component
public class RabbitMQSender {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(String msg) {
		log.info("发送消息:" + msg);
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, msg);
	}
}
