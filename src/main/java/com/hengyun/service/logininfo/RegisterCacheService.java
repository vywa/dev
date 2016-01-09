package com.hengyun.service.logininfo;

import com.hengyun.domain.loginInfo.RegisterCache;
import com.hengyun.domain.loginInfo.constant.AccountStatus;

/*
 *  注册缓存
 * */
public interface RegisterCacheService {

	//加载缓存
	public void loadRegisterCache(String sign);
	
	//销毁缓存
	public void destroyRegisterCache(String sign);
	
	//更新缓存
	public void updateRegisterCache(String sign);
	
	//增加次数
	public void addTryCount(String sign);
	
	//获取尝试次数
	public int getTryCount(String sign);
	
	//用户是否存在
	public boolean existBySign(String sign);
	
	//查询验证码
	public String getConfirmCode(String sign);
	
	//设定验证码
	public void setConfirmCode(String sign,String confirmCode);
	
	//查询用户状态
	public AccountStatus getStatus(String sign);
	
}
