package com.hengyun.dao.impl.doctor;

import com.hengyun.dao.casehistory.ReTreateInfoDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.ReTreateInfo;

/*
 *  回访数据访问层实现
 * */
public class ReTreateInfoDaoImpl extends BaseMongodbDaoImpl<ReTreateInfo,Integer> implements ReTreateInfoDao{

	@Override
	protected Class<ReTreateInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return ReTreateInfo.class;
	}

}
