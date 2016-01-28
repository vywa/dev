package com.hengyun.service.impl.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerMessageListener implements MessageListener{

	private static final Logger log = LoggerFactory.getLogger(ConsumerMessageListener.class);
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage textMsg = (TextMessage)message;
		log.info("接收到一条纯文本消息");
		
		try {
			System.out.println("消息内容是: "+textMsg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
