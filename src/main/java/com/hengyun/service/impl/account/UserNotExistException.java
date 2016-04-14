package com.hengyun.service.impl.account;

import com.hengyun.util.exception.ThealthException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午4:45:00
* 用户不存在
*/
public class UserNotExistException extends ThealthException{

	
	public UserNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

	
}
