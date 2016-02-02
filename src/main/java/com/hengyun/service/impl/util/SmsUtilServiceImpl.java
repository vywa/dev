package com.hengyun.service.impl.util;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.util.SmsUtilService;
import com.hengyun.util.sms.SubmitResult;
import com.hengyun.util.sms.sender.SmsSender;

@Service
public class SmsUtilServiceImpl implements SmsUtilService{

	private static final Logger log = LoggerFactory.getLogger(SmsUtilServiceImpl.class);
	@Resource
	private RegisterCacheService registerCacheService;
	
	@Override
	public int sms(String mobilephone) {
	
		int codeNum = (int)(Math.random()*1000000);
		codeNum = codeNum>100000?codeNum:codeNum+100000;
		//存储在缓存内
		registerCacheService.setConfirmCode(mobilephone, String.valueOf(codeNum));
		
		SubmitResult result;
		SmsSender sms = new SmsSender(mobilephone,codeNum);
		result =  sms.send();
		if(result!=null){
			if(result.getCode()==2){
				return 2;
			}
		} else {
			log.error("手机号 "+mobilephone+" 发送短信失败");
			return -3;
		}
		return 0;
	}

}
