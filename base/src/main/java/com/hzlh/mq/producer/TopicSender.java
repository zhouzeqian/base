package com.hzlh.mq.producer;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("topicSender")
public class TopicSender {
	@Resource(name="jmsTopicTemplate")
	private JmsTemplate  jmsTopicTemplate;
	public void sendTopic(String destination,final Object message){
	
		jmsTopicTemplate.send(destination, new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return jmsTopicTemplate.getMessageConverter().toMessage(message, session);
			}
			
		});
		
	}
}
