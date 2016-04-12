package com.hengyun.service.impl.message;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.stereotype.Service;

import com.hengyun.service.message.SmsProducerService;

//实际发送消息者
@Service
public class ProducerSmsServiceImpl implements SmsProducerService{

	@Resource
	private SmsServiceImpl smsServiceImpl;
	@Resource
	 private Destination smsQueue;   


	

	@Override
	public void sendSms(String message) {
		// TODO Auto-generated method stub
		smsServiceImpl.sendMessage(smsQueue, message);
	}
}
