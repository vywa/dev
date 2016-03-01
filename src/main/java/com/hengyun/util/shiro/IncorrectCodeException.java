package com.hengyun.util.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 下午6:57:06
* 验证码错误异常
*/
public class IncorrectCodeException extends AuthenticationException{

	public IncorrectCodeException(){
		super();
	}
	
	public IncorrectCodeException(String message,Throwable cause){
		super(message,cause);
	}
	
	public IncorrectCodeException(String message){
		super(message);
	}
	
	public IncorrectCodeException(Throwable cause){
		super(cause);
	}
}
