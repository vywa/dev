package com.hengyun.domain.loginInfo;

import com.hengyun.domain.common.BaseResponseCode;
import com.hengyun.domain.information.Information;

/*
 *  注册返回码
 * */
public class LoginResult extends BaseResponseCode{

	private int userCode;					//用户代号		2,3

	private int userId;							//用户userId;
	
	private Information info;				//用户基本资料
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}

	
	
}
