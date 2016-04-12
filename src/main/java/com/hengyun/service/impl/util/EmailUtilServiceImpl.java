package com.hengyun.service.impl.util;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.util.EmailUtilService;
import com.hengyun.util.mail.SimpleMail;

@Service
public class EmailUtilServiceImpl implements EmailUtilService{

	private static final Logger log = LoggerFactory.getLogger(EmailUtilServiceImpl.class);
	@Resource 
	private RegisterCacheService registerCacheService;
	
	@Resource
	private SimpleMail simpleMail;
	
	@Override
	public int email(String email) {
		// TODO Auto-generated method stub
		int codeNum = (int)(Math.random()*10000);
		codeNum = codeNum>1000?codeNum:codeNum+1000;
		registerCacheService.setConfirmCode(email, String.valueOf(codeNum));
	//	registerCacheService.addTryCount(email);
		String subject = "天衡会员确认邮件";
		String content = "您本次验证码是"+codeNum+"如果非本人操作，请忽略。";
		String to = email;
		log.debug("发送给 "+email+"的邮件已经发送");
		
		simpleMail.sendMail( subject,  content,  to);
		
		return 2;
	}

}
