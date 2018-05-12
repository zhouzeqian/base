package com.kxll.controller;

import com.kxll.rabbitmq.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rabbitmq")
@RestController
public class RabbitMQController {
    @Autowired
    RabbitSender rabbitSender;

    @RequestMapping("send")
    public void send(String msg){
        rabbitSender.sendMsg(msg);
    }
}
