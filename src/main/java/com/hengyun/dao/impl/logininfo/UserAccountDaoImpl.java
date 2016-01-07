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

	//添加用户，返回用户的id
	public int addUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return 0;
	}


}
