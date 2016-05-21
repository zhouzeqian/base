package com.hzlh.mq.producer;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("queueSender")
public class QueueSender {
	@Resource(name="jmsQueueTemplate")
	private JmsTemplate   jmsQueueTemplate;
	
	public void sendQueue(String destination,final Object message){
		jmsQueueTemplate.send(destination, new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
			
				return jmsQueueTemplate.getMessageConverter().toMessage(message, session);
			}
			
		});
		
	}
}
