package com.hengyun.service.impl.message;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.hengyun.service.util.EmailUtilService;

//消息处理类
@Service
public class EmailListener {

	private static final Logger log = LoggerFactory.getLogger(EmailListener.class);
	
	@Resource
	private EmailUtilService emailUtilService;

	
	public String  handleMessage(String message) {   
	//	log.debug("向邮箱 "+message+"发送一条消息");
       int code = emailUtilService.email(message);
       return String.valueOf(code);
        
    }   
}
