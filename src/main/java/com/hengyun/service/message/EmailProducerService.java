package com.hengyun.service.message;

import javax.jms.Destination;

/*
 * 消息产生者
 * */
public interface EmailProducerService{

	public void sendEmail(String message);
	
}
