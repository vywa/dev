package com.hengyun.dao.impl.logininfo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.domain.common.IndexCollection;

/*
 *  管理员数据访问层实现
 * */

public class IndexCollectionDaoImpl extends BaseMongodbDaoImpl<IndexCollection,Integer> implements IndexCollectiontDao{

	@Override
	protected Class<IndexCollection> getEntityClass() {
		// TODO Auto-generated method stub
		return IndexCollection.class;
	}

	public boolean load() {
		// TODO Auto-generated method stub
		IndexCollection indexCollection = new IndexCollection();
		indexCollection.setDocterID(1000000000);
		indexCollection.setPatientID(200000000);
		
		if(!this.mongoTemplate.collectionExists(IndexCollection.class)){
			this.mongoTemplate.save(indexCollection);
			return false;
		}
		return true;
	}

	//索引自增
	public int updateIndex(String name) {
		// TODO Auto-generated method stub
		int userId =0;
		Query query = new Query();
		 Update update = new Update();
		 IndexCollection index=null;
		switch(name){
			case "patient":	
				 query = Query.query(Criteria.where("patientID").gt(0));
		         update = new Update();
		        update.inc("patientID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getPatientID();
				 break;
			case "doctor":
				 query = Query.query(Criteria.where("docterID").gt(0));
		         update = new Update();
		        update.inc("docterID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getDocterID();
				 break;
			case "admin":
				 query = Query.query(Criteria.where("adminID").gt(0));
		         update = new Update();
		        update.inc("adminID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getAdminID();
				 break;
				 
			default:
				 break;
		}
		return userId;
	}

	
	

}
