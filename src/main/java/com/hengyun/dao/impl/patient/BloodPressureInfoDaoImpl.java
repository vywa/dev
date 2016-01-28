package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.BloodPressureInfoDao;
import com.hengyun.domain.patient.BloodPressureInfo;

/*
 *  血糖数据访问层实现
 * */

public class BloodPressureInfoDaoImpl extends BaseMongodbDaoImpl<BloodPressureInfo,Integer> implements BloodPressureInfoDao{

	@Override
	protected Class<BloodPressureInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return BloodPressureInfo.class;
	}

}
