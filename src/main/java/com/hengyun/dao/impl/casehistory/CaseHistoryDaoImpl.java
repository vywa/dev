package com.hengyun.dao.impl.casehistory;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.CaseHistoryDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.common.IndexCollection;


/*
 *  病历
 * */

public class CaseHistoryDaoImpl extends BaseMongodbDaoImpl<CaseHistory,Integer> implements CaseHistoryDao{


	@Override
	protected Class<CaseHistory> getEntityClass() {
		// TODO Auto-generated method stub
		return CaseHistory.class;
	}

	public int addCaseHistory(CaseHistory caseHistory) {
		// TODO Auto-generated method stub
		int id =0;
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientID").gt(0));
        Update update = new Update();
	        update.inc("caseHistoryID", 1);
	        IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
			 id = index.getCaseHistoryID();
		
			 caseHistory.setCaseHistoryId(id);
	
		
		this.mongoTemplate.save(caseHistory);
		
		
		 return id;
	}
	
	
    
}
