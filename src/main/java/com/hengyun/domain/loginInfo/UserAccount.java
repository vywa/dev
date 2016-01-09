package com.hengyun.domain.loginInfo;

import java.io.Serializable;

import com.hengyun.domain.loginInfo.constant.AccountStatus;
import com.hengyun.domain.loginInfo.constant.UserCatagory;

/*
 *  用户账号基本信息
 * */
public class UserAccount implements Serializable{


	/**
	 * 
	 */

	private int id;																			//用户ID
	private UserCatagory userCatagory; 								//用户类型（系统管理员=1,用户管理员，医生，病人，游客）
	private String 							username;							//用户名
	private String 							mobilephone;					//用户手机号
	private String 							email;									//用户邮箱
	private String							password;							//用户密码
	private AccountStatus			accountStatus;					//用户账号状态
	
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UserCatagory getUserCatagory() {
		return userCatagory;
	}


	public void setUserCatagory(UserCatagory userCatagory) {
		this.userCatagory = userCatagory;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMobilephone() {
		return mobilephone;
	}


	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public AccountStatus getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}


		public UserAccount() {
		super();
	}

	
	
}

