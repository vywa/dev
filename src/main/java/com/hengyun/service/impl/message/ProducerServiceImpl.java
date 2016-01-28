package com.hengyun.service.impl.message;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.hengyun.service.message.ProducerService;

/*
 * 消息产生者
 * */
@Component
public class ProducerServiceImpl implements ProducerService{

	private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);
	@Resource
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination responseQueue;
	@Override
	public void sendMessage(Destination destination, String message) {
		// TODO Auto-generated method stub
		log.info("生产者产生一条消息");
		jmsTemplate.send(destination, new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				TextMessage  textMessage= session.createTextMessage(message);
				textMessage.setJMSReplyTo(responseQueue);
				return textMessage;
			}
		});
	}

	
	
}
