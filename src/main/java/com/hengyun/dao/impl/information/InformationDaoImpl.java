package com.hengyun.dao.impl.information;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.common.GeneralInfo;


/*
 *  管理员数据访问层实现
 * */

public class InformationDaoImpl extends BaseMongodbDaoImpl<GeneralInfo,Integer> implements InformationDao{

	@Override
	protected Class<GeneralInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return GeneralInfo.class;
	}

}
