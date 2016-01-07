package com.hengyun.domain.loginInfo;

import java.util.Map;

import com.hengyun.domain.common.BaseResponseCode;

public class RegisterResult extends BaseResponseCode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2367324233014234952L;

	//error 和success
	private String response;
	
	private Map<String,String> flag;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}


	public RegisterResult(String response, Map<String, String> flag) {
		super();
		this.response = response;
		this.flag = flag;
	}

	public Map<String, String> getFlag() {
		return flag;
	}

	public void setFlag(Map<String, String> flag) {
		this.flag = flag;
	}

	public RegisterResult() {
		super();
	}
	
	
}
