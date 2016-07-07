package com.hengyun.service.logininfo;


import com.hengyun.domain.loginInfo.LoginInfoCache;


/*
 *  用户登陆会话缓存
 * */
public interface LoginInfoCacheService {

	//加载缓存
	public void loadCache(LoginInfoCache loginInfoCache);
	
	//销毁缓存
	public void destroyCache(String tocken);
	
	//是否存在会话
	public boolean valideSession(String tocken);
	
	//根据id获得tocken
	public String getTockenById(int id);
	
	//查询用户id
	public int getUserId(String tocken);
	
	public boolean loginByTocken(String tocken,int userId,String oldTocken);
	
	//用户是否在线
	public int isOnline(String tocken);
	
	//设备是否在线
	public void deviceState(int userId,String device);
	
	//获取设备状态
	public int getState(int userId);
}
