package com.hengyun.dao.impl.hospital;


import com.hengyun.dao.hospital.DocterDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.hospital.Docter;


/*
 *  医生
 * */

public class DocterDaoImpl extends BaseMongodbDaoImpl<Docter,Integer> implements DocterDao{


	@Override
	protected Class<Docter> getEntityClass() {
		// TODO Auto-generated method stub
		return Docter.class;
	}



}
