package com.hengyun.domain.loginInfo;

import java.io.Serializable;

import com.hengyun.domain.common.BaseResponseCode;

/*
 *  注册返回码
 * */
public class PasswordResult extends BaseResponseCode implements Serializable{
	private String oldPassword;				//旧密码

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
}
