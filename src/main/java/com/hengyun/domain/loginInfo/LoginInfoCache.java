package com.hengyun.domain.loginInfo;

import java.io.Serializable;

import com.hengyun.domain.loginInfo.constant.UserCatagory;

/*
 *  用户登陆信息缓存
 *  根据sessionToken进行标示
 * */

public class LoginInfoCache implements Serializable{

	private String tocken;							//会话标识

	private int userId;												//用户ID
	private String username;									//用户名称
	private UserCatagory userCatagory; 								//用户类型（系统管理员=1,用户管理员，医生，病人，游客）
	
	
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserCatagory getUserCatagory() {
		return userCatagory;
	}
	public void setUserCatagory(UserCatagory userCatagory) {
		this.userCatagory = userCatagory;
	}
	
	
}
