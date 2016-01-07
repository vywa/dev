package com.hengyun.domain.loginInfo;

import java.io.Serializable;

import com.hengyun.domain.loginInfo.constant.UserCatagory;

/*
 *  用户登陆信息缓存
 *  根据sessionToken进行标示
 * */

public class LoginInfoCache implements Serializable{

	private int ID;												//用户ID
	private String username;							//用户名称
	private UserCatagory userCatagory; 								//用户类型（系统管理员=1,用户管理员，医生，病人，游客）


	
}
