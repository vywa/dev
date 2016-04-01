package com.hengyun.domain.loginInfo;

import java.io.Serializable;



/*
 *  注册返回码
 * */
public class RegisterResult  implements Serializable{
	
	private String code;					//返回的标志码
	
	private String message;					//返回信息描述			

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
