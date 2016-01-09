package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.logininfo.LoginInfoLogDao;
import com.hengyun.domain.loginInfo.LoginInfoLog;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoLogService;


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

	public List<LoginInfoLog> getLoginInfoById(int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return loginInfoLogDao.queryList(query);
	}

	public LoginInfoLog getLastLogin(int userId) {
		// TODO Auto-generated method stub
		Query query =Query.query(Criteria.where("userId").is(userId));
		return loginInfoLogDao.queryOne(query);
	}

	
	

	
}
