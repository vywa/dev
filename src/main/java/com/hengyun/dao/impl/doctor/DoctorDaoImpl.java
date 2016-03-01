package com.hengyun.dao.impl.doctor;

import com.hengyun.dao.doctor.DoctorDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.doctor.Doctor;

/*
 *  管理员数据访问层实现
 * */
public class DoctorDaoImpl extends BaseMongodbDaoImpl<Doctor,Integer> implements DoctorDao{

	@Override
	protected Class<Doctor> getEntityClass() {
		// TODO Auto-generated method stub
		return Doctor.class;
	}

}
