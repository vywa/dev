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


	public void sendsms(String message){
		for(int i=0;i<2;i++){
	//		producerService.sendMessage(destination, "你好，生产者，这是消息: "+(i+1));
		//	producerService.sendMessage(sessionAwareQueue, " 测试SessionAwareMessageListener");
		//	smsServiceImpl.sendMessage(adapterQueue, "测试MessageListenerAdapter　"+"实现短信的异步发送");
		}
		//smsServiceImpl.sendMessage(smsQueue, message);
	}


	@Override
	public void sendSms(String message) {
		// TODO Auto-generated method stub
		smsServiceImpl.sendMessage(smsQueue, message);
	}
}
