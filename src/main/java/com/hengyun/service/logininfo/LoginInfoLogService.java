package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginInfoLog;
import com.hengyun.service.BaseService;

public interface LoginInfoLogService  extends BaseService<LoginInfoLog,Integer> {


	public List<LoginInfoLog> getLoginInfoById(int userId) ;
	
	public LoginInfoLog  getLastLogin(int userId);
	
	public List<LoginInfoLog> getLoginInfoAll();
	
	public void insertLog(LoginInfoLog loginInfoLog);
	

}
