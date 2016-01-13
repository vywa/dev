package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.CaseHistoryDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.CaseHistory;


/*
 *  病历
 * */

public class CaseHistoryDaoImpl extends BaseMongodbDaoImpl<CaseHistory,Integer> implements CaseHistoryDao{


	@Override
	protected Class<CaseHistory> getEntityClass() {
		// TODO Auto-generated method stub
		return CaseHistory.class;
	}
	
	
    
}
