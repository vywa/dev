package com.hengyun.domain.loginInfo.response;

import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.DoctorInfo;
import com.hengyun.domain.loginInfo.UserAccount;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月9日 下午2:41:39
* 类说明
*/
public class UserAccountResponse extends ResponseCode{

	private UserAccount account;
	private DoctorInfo info;
	
	
	
	public DoctorInfo getInfo() {
		return info;
	}

	public void setInfo(DoctorInfo info) {
		this.info = info;
	}

	public UserAccount getAccount() {
		return account;
	}

	public void setAccount(UserAccount account) {
		this.account = account;
	}
	
	
}
