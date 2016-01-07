package com.hengyun.service.logininfo;

import com.hengyun.domain.loginInfo.LoginInfoCache;
import com.hengyun.domain.loginInfo.constant.UserCatagory;

/*
 *  用户登陆会话缓存
 * */
public interface LoginInfoCacheService {

	//加载缓存
	public void loadCache(LoginInfoCache loginInfoCache);
	
	//销毁缓存
	public void destroyCache(LoginInfoCache loginInfoCache);
	
	//是否存在会话
	public boolean valideSession(LoginInfoCache loginInfoCache);
	
	//查询用户id
	public int getUserId(LoginInfoCache loginInfoCache);
	
	//查询用户权限
	public UserCatagory getUserCatagory(LoginInfoCache loginInfoCache);
}
