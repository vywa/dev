package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.UserAccountService;

@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount,Integer> implements UserAccountService{

	@Resource 
	private UserAccountDao userAccountDao;
	

	public UserAccount getUserAccountById(int id) {
		// TODO Auto-generated method stub
		return userAccountDao.queryById(id);
	}


	//获取所有用户账号
	public List<UserAccount> getUserAccountALL() {
		// TODO Auto-generated method stub
		
		return null;
	}


	//注册账号
	public int registerAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
	//是否注册
		//添加用户信息
		
		
		//
		return 10000;
		
	}

	//更新账号
	public void updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		
		
	}

	

	
}
