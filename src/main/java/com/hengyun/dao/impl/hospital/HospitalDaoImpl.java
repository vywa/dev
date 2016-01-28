package com.hengyun.dao.impl.hospital;

import com.hengyun.dao.hospital.HospitalDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.hospital.Hospital;


/*
 *  上传文件
 * */

public class HospitalDaoImpl extends BaseMongodbDaoImpl<Hospital,Integer> implements HospitalDao{


	@Override
	protected Class<Hospital> getEntityClass() {
		// TODO Auto-generated method stub
		return Hospital.class;
	}



}
