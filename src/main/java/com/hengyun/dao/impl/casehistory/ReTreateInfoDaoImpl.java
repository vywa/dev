package com.hengyun.dao.impl.casehistory;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.ReTreateInfoDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.ReTreateInfo;
import com.hengyun.domain.common.IndexCollection;


/*
 *  回访
 * */

public class ReTreateInfoDaoImpl extends BaseMongodbDaoImpl<ReTreateInfo,Integer> implements ReTreateInfoDao{


	@Override
	protected Class<ReTreateInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return ReTreateInfo.class;
	}

	public int addReTreate(ReTreateInfo reTreateInfo) {
		// TODO Auto-generated method stub
		int id =0;
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("reTreateInfoID").gte(0));
        Update update = new Update();
	        update.inc("reTreateInfoID", 1);
	        IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
			 id = index.getReTreateInfoID();
			 
			 reTreateInfo.setId(id);
			 reTreateInfo.setStatus("unhandled");
			 reTreateInfo.setViewTime(new Date());
		
		this.mongoTemplate.save(reTreateInfo);
		
		
		 return id;
	}
	
	
    
}
