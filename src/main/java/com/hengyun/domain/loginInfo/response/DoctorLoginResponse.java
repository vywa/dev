package com.hengyun.domain.loginInfo.response;

import java.io.Serializable;

import com.hengyun.domain.common.BaseResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月9日 上午11:19:56
* 医生登陆返回结果
*/
public class DoctorLoginResponse extends BaseResponseCode implements Serializable{

//	private int userCode;					//用户代号	2,3
	
	private int userId;							//用户userId;
	private String tocken;							//tocken
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
	
	
}
