package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoLogService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  登陆业务
 * */
public class LoginInfoServiceImpl extends BaseServiceImpl<LoginInfo,Integer> implements LoginInfoService{

	@Resource 
	private LoginInfoDao loginInfoDao;
	
	@Resource 
	private LoginInfoLogService loginInfoLogService;
	
	public List<LoginInfo> getLoginInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *  登陆业务
	 * */
	
	public void login(LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		//比较用户名密码合法
		
		//添加登陆表
		
		
		//更新缓存
	}

	/*
	 *  退出业务
	 * */
	public void logout(String tocken) {
		
		//记录登陆日志
		
		
		//销毁session信息
		
		
		//删除登陆表中的记录
		
		
	}

}
