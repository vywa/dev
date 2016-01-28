package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  返回码基类，由标志码和描述信息组成
 * */
public  class ForumResponseCode  implements Serializable{

	private int responseCode;							//类型码
	private String description;							//描述
	
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
