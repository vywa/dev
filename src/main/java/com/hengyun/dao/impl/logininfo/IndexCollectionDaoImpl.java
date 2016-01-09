package com.hengyun.dao.impl.logininfo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.loginInfo.UserAccount;

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

	
	

}
