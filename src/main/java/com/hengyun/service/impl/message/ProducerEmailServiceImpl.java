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
	
	public void sendSms(String message){
		for(int i=0;i<2;i++){
	//		producerService.sendMessage(destination, "你好，生产者，这是消息: "+(i+1));
		//	producerService.sendMessage(sessionAwareQueue, " 测试SessionAwareMessageListener");
		//	smsServiceImpl.sendMessage(adapterQueue, "测试MessageListenerAdapter　"+"实现短信的异步发送");
		}
	//	emailServiceImpl.sendEmail(emailQueue, message);
	}

	@Override
	public void sendEmail(String message) {
		// TODO Auto-generated method stub
		emailServiceImpl.sendMessage(emailQueue, message);
	}
}
