package com.hengyun.domain.loginInfo;

import com.hengyun.domain.common.BaseResponseCode;
import com.hengyun.domain.information.Information;

/*
 *  注册返回码
 * */
public class ThirdLoginResult extends LoginResult{

	private String register;					//是否是第一次注册
	
	private String password;				//用户密码
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}
	
	
	
}
