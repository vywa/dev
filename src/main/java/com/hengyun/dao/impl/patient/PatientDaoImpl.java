package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.PatientDao;
import com.hengyun.domain.patient.Patient;

/*
 *  管理员数据访问层实现
 * */
public class PatientDaoImpl extends BaseMongodbDaoImpl<Patient,Integer> implements PatientDao{

	@Override
	protected Class<Patient> getEntityClass() {
		// TODO Auto-generated method stub
		return Patient.class;
	}

}
