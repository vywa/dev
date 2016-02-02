package com.hengyun.service.impl.message;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyun.service.util.SmsUtilService;

//短信发送处理类
@Service
public class SmsListener {

	private static final Logger log = LoggerFactory.getLogger(SmsListener.class);
	
	@Resource
	private SmsUtilService smsUtilServie;

	
	//发送短信
	public String handleMessage(String message) {   
		log.debug("向手机号 " + message+" 发送一条短信");
		int code =smsUtilServie.sms(message);
        return String.valueOf(code);
        
    }   
}
