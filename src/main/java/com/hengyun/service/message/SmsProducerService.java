package com.hengyun.service.message;

import javax.jms.Destination;

/*
 * 消息产生者
 * */
public interface SmsProducerService{

	public void sendSms( String message);
	
}
