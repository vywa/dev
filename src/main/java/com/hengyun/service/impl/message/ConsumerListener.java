package com.hengyun.service.impl.message;

//消息处理类
public class ConsumerListener {

	public void receiveMessage(String message) {   
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);   
    }   
	public String handleMessage(String message) {   
        System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
        return "好吧";
        
    }   
}
