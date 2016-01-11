package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.loginInfo.constant.AccountStatus;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.logininfo.UserAccountService;

public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount, Integer> implements UserAccountService {

	@Resource
	private UserAccountDao userAccountDao;

	public UserAccountDao getUserAccountDao() {
		return userAccountDao;
	}

	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Resource
	private RegisterCacheService registerCacheService;

	public UserAccount getUserAccountById(int id) {
		// TODO Auto-generated method stub
		return userAccountDao.queryById(id);
	}

	// 获取所有用户账号
	public List<UserAccount> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("_id").exists(true));
		return userAccountDao.queryList(query);
	}

	// 注册账号
	public int registerAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountDao.addUserAccount(userAccount);

	}

	// 更新账号
	public void updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("mobilephone").is(userAccount.getMobilephone()));

		Update update = Update.update("password", userAccount.getPassword());
		userAccountDao.updateFirst(query, update);

	}

	// 用户是否存在
	public boolean existUserAccountBySign(String sign, String type) {
		// TODO Auto-generated method stub
	
		Query query = null;
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign));
		}
		UserAccount userAccount = userAccountDao.queryOne(query);
		if (userAccount == null) {
		
			return false;
		} else {
			return true;
		}
	}

	// 判断用户是否存在
	public int validateUserBySign(String sign, String type,String password) {
		// TODO Auto-generated method stub

		Query query = null;

		// 检查是否存在
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("password").is(password)));
		}
		UserAccount userAccount = userAccountDao.queryOne(query);
		if (userAccount == null) {
			return -1;
		} else {
			int userId = userAccount.getId();
			return userId;
		}
	
	}

	public int registerThirdAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountDao.addUserAccount(userAccount);
	
	}

	public int validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
