package com.hengyun.domain.common;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月25日 上午10:40:35
* app返回码基类
*/
public class AppResponse implements Serializable{

	private int code;											//返回码
	private String message;							//描述信息
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
