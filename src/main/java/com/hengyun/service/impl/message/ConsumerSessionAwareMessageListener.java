package com.hengyun.service.impl.message;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage>{

	private static final Logger log = LoggerFactory.getLogger(ConsumerSessionAwareMessageListener.class);
	private Destination destination;
	
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		// TODO Auto-generated method stub
		log.info("收到一条消息");
		log.info("消息内容是: "+message.getText());
		MessageProducer messageProducer = session.createProducer(destination);
		Message textMessage = session.createTextMessage("该类在监听");
	
		messageProducer.send(textMessage);
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	
}
