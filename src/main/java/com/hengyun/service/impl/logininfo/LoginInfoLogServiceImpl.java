package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.logininfo.LoginInfoLogDao;
import com.hengyun.domain.loginInfo.LoginInfoLog;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoLogService;

@Service
public class LoginInfoLogServiceImpl extends BaseServiceImpl<LoginInfoLog,Integer> implements LoginInfoLogService{

@Resource
private LoginInfoLogDao loginInfoLogDao;

	public List<LoginInfoLog> getLoginInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertLog(LoginInfoLog loginInfoLog) {
		// TODO Auto-generated method stub
		loginInfoLogDao.save(loginInfoLog);
	}

	public LoginInfoLog getLoginInfoById(int id) {
		// TODO Auto-generated method stub
		return loginInfoLogDao.queryById(id);
	}

	
	

	
}
