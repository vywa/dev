package com.hengyun.service.logininfo.mysql;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.LoginResult;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月2日 上午9:21:45
* 登陆业务类
*/
public interface LoginService {
	
	/*
	 *  获取所有登陆信息
	 * 
	 * */
	public List<LoginInfo> getLoginInfoAll();
	
	/*
	 * 
	 * 通过用户名密码登陆
	 * 
	 * */
	public LoginResult loginByUsername(LoginInfo loginInfo,String type);
	
	/*
	 * 
	 * 通过tocken登陆
	 * 
	 * */
	public boolean loginByTocken(String tocken,LoginInfo loginInfo);
	/*
	 * 
	 * 通过第三方登陆
	 * 
	 * */
	public LoginResult  loginByThirdPart(String tocken,LoginInfo loginInfo);
	
	/*
	 * 
	 * 通过id获得tocken
	 * 
	 * */
	public String getTockenById(int userId);
	
	/*
	 * 
	 * 用户是否在线
	 * 
	 * */
	public int isOnline(String tocken);
	
	/*
	 * 退出系统
	 * 
	 * */
	public boolean logout(String tocken);

}
