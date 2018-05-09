package com.llc.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.llc.config.RabbitMQConfig;

@Component
public class RabbitMQConsumer {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void consumeMessage(String message) {
		log.info("收到消息:" + message);
	}
}
