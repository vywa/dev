package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.ReTreateInfoDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.ReTreateInfo;


/*
 *  回访
 * */

public class ReTreateInfoDaoImpl extends BaseMongodbDaoImpl<ReTreateInfo,Integer> implements ReTreateInfoDao{


	@Override
	protected Class<ReTreateInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return ReTreateInfo.class;
	}
	
	
    
}
