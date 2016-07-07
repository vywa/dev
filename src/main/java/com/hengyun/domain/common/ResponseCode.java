package com.hengyun.domain.common;

import java.io.Serializable;

/*
 *  返回码基类，由标志码和描述信息组成
 * */

public  class ResponseCode  implements Serializable{

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
