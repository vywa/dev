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
		
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("docterID").gt(0));
        Update update = new Update();
        update.inc("docterID", 1);
        
       // this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int userId = index.getDocterID();
		userAccount.setId(userId);
		this.mongoTemplate.save(userAccount);
		
		
		 return userId;
	}


}
