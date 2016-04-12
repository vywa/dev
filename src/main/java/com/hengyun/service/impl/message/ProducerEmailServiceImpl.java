package com.hengyun.service.impl.message;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.stereotype.Service;

import com.hengyun.service.message.EmailProducerService;

//实际发送消息者
@Service
public class ProducerEmailServiceImpl implements EmailProducerService{

	@Resource
	private EmailServiceImpl emailServiceImpl;
	@Resource
	 private Destination emailQueue;   
	
	

	@Override
	public void sendEmail(String message) {
		// TODO Auto-generated method stub
		emailServiceImpl.sendMessage(emailQueue, message);
	}
}
