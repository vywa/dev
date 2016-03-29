package com.hengyun.domain.loginInfo;

import java.io.Serializable;

/*
 *  用户登陆信息缓存
 *  根据sessionToken进行标示
 * */

public class LoginInfoCache implements Serializable{

	private String tocken;							//会话标识

	private int userId;												//用户ID
	private long lastLoginTime;							//上次登陆时间
	private String ip;													//上次登陆ip
	
	
	
	
	
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
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
