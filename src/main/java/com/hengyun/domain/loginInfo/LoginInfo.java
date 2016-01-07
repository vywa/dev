package com.hengyun.domain.loginInfo;

import java.io.Serializable;
import java.util.List;

/*
 *  用户登陆基本信息
 * */

public class LoginInfo implements Serializable{

	
	private int ID;												//用户ID
	private List<LoginDetail>		loginDetails;			//登陆具体信息
	private int			loginCount;										//在线数量
	
	
	
	

	

	

}

