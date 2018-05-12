package com.kxll.rabbitmq;

import com.kxll.constant.RabbitConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg){
        log.info("发送消息:"+msg);
        rabbitTemplate.convertAndSend(RabbitConstant.EXCHANGE_NAME,RabbitConstant.ROUTING_KEY,msg);
    }
}
