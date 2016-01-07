package com.hengyun.dao.impl.logininfo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.UserAccountDao;
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

	
	  
	
	public boolean existUserByMobilephone(String mobilephone) {
		// TODO Auto-generated method stub
		
		 	Query query = new Query();
	      Criteria criteria = Criteria.where("loginInfo.mobilephone").is(mobilephone);
	      query.addCriteria(criteria);
	     if( this.queryOne(query).equals(null)){
	    	 return false;
	     }
		return true;
	}

}
