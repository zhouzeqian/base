package com.hzlh.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component("myQueueReceiver")
public class MyQueueReceiver extends MessageListenerAdapter{
	private static final Logger log=LoggerFactory.getLogger(MyQueueReceiver.class);
	public void onMessage(Message message, Session session) throws JMSException {
		try {
		String msg = getMessageConverter().fromMessage(message).toString();
		log.info("MyQueueReceiver接受到消息："+msg);
		message.acknowledge();
		}catch (JMSException e) {
		      e.printStackTrace();
	    }
	}
	

}
