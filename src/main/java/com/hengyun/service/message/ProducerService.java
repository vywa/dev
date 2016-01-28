package com.hengyun.service.message;

import javax.jms.Destination;

/*
 * 消息产生者
 * */
public interface ProducerService  {

	public void sendMessage(Destination destination, final String message) ;
	
}
