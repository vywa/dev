package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
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
		} else if(type.equals("workNum")){
			query = Query.query(Criteria.where("workNum").is(sign));
		}
		UserAccount userAccount = userAccountDao.queryOne(query);
		if (userAccount == null) {
		
			return false;
		} else {
			return true;
		}
	}

	// 判断用户身份是否合法
	public LoginResult validateUserBySign(String sign, String type,String password) {
		// TODO Auto-generated method stub
		LoginResult loginResult = new LoginResult();
		Query query = null;

		// 检查是否存在
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("password").is(password)));
				
		}if (type.equals("workNum")) {
			query = Query.query(Criteria.where("workNum").is(sign).andOperator(Criteria.where("password").is(password)));
		}
		UserAccount userAccount = userAccountDao.queryOne(query);
		if (userAccount == null) {
			return null;
		} else {
			int userId = userAccount.getId();
			//暂时将用户id放入code中
			loginResult.setCode(String.valueOf(userId));	
			if(userAccount.getCatagory().equals("doctor")){
				loginResult.setUserCode(2);
			} else if(userAccount.getCatagory().equals("patient")) {
				loginResult.setUserCode(3);
			}	else if(userAccount.getCatagory().equals("admin")){
				loginResult.setUserCode(1);
			} else if(userAccount.getCatagory().equals("root")){
				loginResult.setUserCode(0);
			} else if(userAccount.getCatagory().equals("third")) {
				loginResult.setUserCode(4);
			} else {
				loginResult.setUserCode(5);					//游客???
			}
			return loginResult;
		}
	
	}

	public int registerThirdAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		
		//设置病人标志
		userAccount.setCatagory("patient");
		return userAccountDao.addUserAccount(userAccount);
	
	}

	public UserAccount validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		UserAccount userAccount=null ;
		if(type.equals("QQ")){
			Query query = Query.query(Criteria.where("QQ").is(sign));
			userAccount = userAccountDao.queryOne(query);
		}else if(type.equals("weiChat")){
			Query query = Query.query(Criteria.where("weiChat").is(sign));
			userAccount = userAccountDao.queryOne(query);
		} else if(type.equals("weiBo")){
			Query query = Query.query(Criteria.where("weiBo").is(sign));
			userAccount = userAccountDao.queryOne(query);
		}
		if(userAccount!=null){
			return userAccount;
		}
	
		return null;
	}



}
