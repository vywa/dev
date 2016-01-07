package com.hengyun.dao.impl.logininfo;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.LoginInfoLogDao;
import com.hengyun.domain.loginInfo.LoginInfoLog;

/*
 *  登陆日志数据访问层实现
 * */
public class LoginInfoLogDaoImpl extends BaseMongodbDaoImpl<LoginInfoLog,Integer> implements LoginInfoLogDao{

	@Override
	protected Class<LoginInfoLog> getEntityClass() {
		// TODO Auto-generated method stub
		return LoginInfoLog.class;
	}

}
