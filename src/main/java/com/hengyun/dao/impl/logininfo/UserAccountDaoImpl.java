package com.hengyun.dao.impl.logininfo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.loginInfo.UserAccount;

/*
 *  管理员数据访问层实现
 * */

public class UserAccountDaoImpl extends BaseMongodbDaoImpl<UserAccount,Integer> implements UserAccountDao{

	@Override
	protected Class<UserAccount> getEntityClass() {
		// TODO Auto-generated method stub
		return UserAccount.class;
	}

	//添加用户，返回用户的id
	public int addUserAccount(UserAccount userAccount) {
		int userId =0;
		// TODO Auto-generated method stub
		if(userAccount.getCatagory().equals("patient")){
			Query query = Query.query(Criteria.where("patientID").gt(0));
	        Update update = new Update();
	        update.inc("patientID", 1);
	        IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
			 userId = index.getPatientID();
			userAccount.setId(userId);
		} else if(userAccount.getCatagory().equals("doctor")) {
		Query query = Query.query(Criteria.where("docterID").gt(0));
        Update update = new Update();
        update.inc("docterID", 1);
        
       // this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		 userId = index.getDocterID();
		userAccount.setId(userId);
		}else if(userAccount.getCatagory().equals("admin")) {
			Query query = Query.query(Criteria.where("adminID").gt(0));
	        Update update = new Update();
	        update.inc("adminID", 1);
	        
	       // this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
			IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
			 userId = index.getAdminID();
			userAccount.setId(userId);
			}
		this.mongoTemplate.save(userAccount);
		
		
		 return userId;
	}


}
