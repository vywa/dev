package com.hengyun.domain.loginInfo;

import java.util.Map;

import com.hengyun.domain.common.BaseResponseCode;

/*
 *  注册返回码
 * */
public class LoginResult extends BaseResponseCode{

	private int userCode;					//用户代号		2,3

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	
	
}
