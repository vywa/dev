package com.hengyun.dao.impl.doctor;

import com.hengyun.dao.doctor.DocterDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.docter.Docter;

/*
 *  管理员数据访问层实现
 * */
public class DocterDaoImpl extends BaseMongodbDaoImpl<Docter,Integer> implements DocterDao{

	@Override
	protected Class<Docter> getEntityClass() {
		// TODO Auto-generated method stub
		return Docter.class;
	}

}
