package com.hengyun.service.impl.message;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;



/*
 * 邮件消息产生者
 * */
@Component
public class EmailServiceImpl{

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	@Resource
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination emailResponseQueue;				//邮件回复接收队列
	
	


	public void sendMessage(Destination destination, String message) {
		// TODO Auto-generated method stub
		log.info("向邮箱"+message+"一条消息");
		
		jmsTemplate.send(destination, new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				TextMessage  textMessage= session.createTextMessage(message);
			//	textMessage.setJMSReplyTo(emailResponseQueue);
				return textMessage;
			}
		});
	}

	
	
}
