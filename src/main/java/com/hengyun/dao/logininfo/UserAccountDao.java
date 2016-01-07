package com.hengyun.dao.logininfo;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.loginInfo.UserAccount;

/*
 *  管理员数据访问层
 * */
public interface UserAccountDao extends BaseMongodbDao<UserAccount,Integer>{

	public int addUserAccount(UserAccount userAccount);
}
