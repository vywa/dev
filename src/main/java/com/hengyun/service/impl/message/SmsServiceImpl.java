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
import org.springframework.stereotype.Service;

import com.hengyun.service.message.SmsProducerService;

/*
 * 短信消息产生者
 * */
@Service
public class SmsServiceImpl {

	private static final Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);
	
	@Resource
	private JmsTemplate jmsTemplate;
	
	@Resource
	private Destination smsResponseQueue;						//短信回复接收队列
	


	public void sendMessage(Destination destination, String message) {
		// TODO Auto-generated method stub
		log.info("手机"+message+"需要发送一条消息");
		jmsTemplate.send(destination, new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				TextMessage  textMessage= session.createTextMessage(message);
			//	textMessage.setJMSReplyTo(smsResponseQueue);
				return textMessage;
			}
		});
	}
	
}
