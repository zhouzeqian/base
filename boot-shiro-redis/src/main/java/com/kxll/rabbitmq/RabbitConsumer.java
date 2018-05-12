package com.kxll.rabbitmq;

import com.kxll.constant.RabbitConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    Logger log=LoggerFactory.getLogger(this.getClass());
    @RabbitListener(queues = RabbitConstant.QUEUE_NAME)
    public void consumeMessage(String message) {
        log.info("收到消息:"+message);
    }
}
