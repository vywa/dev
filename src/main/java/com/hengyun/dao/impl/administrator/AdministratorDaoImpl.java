package com.hengyun.dao.impl.administrator;

import com.hengyun.dao.administrator.AdministratorDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.administrator.Administrator;

/*
 *  管理员数据访问层实现
 * */
public class AdministratorDaoImpl extends BaseMongodbDaoImpl<Administrator,Integer> implements AdministratorDao{

	@Override
	protected Class<Administrator> getEntityClass() {
		// TODO Auto-generated method stub
		return Administrator.class;
	}

}
