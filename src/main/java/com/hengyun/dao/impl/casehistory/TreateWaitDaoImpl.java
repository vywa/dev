package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.TreateWaitDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.TreateWait;


/*
 *  就诊
 * */

public class TreateWaitDaoImpl extends BaseMongodbDaoImpl<TreateWait,Integer> implements TreateWaitDao{


	@Override
	protected Class<TreateWait> getEntityClass() {
		// TODO Auto-generated method stub
		return TreateWait.class;
	}
	
	
}
