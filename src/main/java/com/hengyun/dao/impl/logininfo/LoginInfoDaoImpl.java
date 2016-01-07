package com.hengyun.dao.impl.logininfo;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfo;


/*
 *  管理员数据访问层实现
 * */
public class LoginInfoDaoImpl extends BaseMongodbDaoImpl<LoginInfo,Integer> implements LoginInfoDao{

	@Override
	protected Class<LoginInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return LoginInfo.class;
	}

}
