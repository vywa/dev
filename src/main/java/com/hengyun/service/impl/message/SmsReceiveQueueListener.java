package com.hengyun.service.impl.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service
public class SmsReceiveQueueListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if(message instanceof TextMessage){
			TextMessage textMessage = (TextMessage)message;
			
			try {
				
				if(textMessage.getText().equals("2")){
					System.out.println("短信发送成功");
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
