package com.hengyun.dao.impl.patient;

import java.util.List;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.BloodSuggerInfoDao;
import com.hengyun.domain.patient.BloodSuggerInfo;

/*
 *  血压数据访问层实现
 * */
public class BloodSuggerInfoDaoImpl extends BaseMongodbDaoImpl<BloodSuggerInfo,Integer> implements BloodSuggerInfoDao{

	@Override
	protected Class<BloodSuggerInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return BloodSuggerInfo.class;
	}


}
