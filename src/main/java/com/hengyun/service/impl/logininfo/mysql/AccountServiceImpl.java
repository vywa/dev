package com.hengyun.service.impl.logininfo.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.logininfo.mysql.AccountDao;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.logininfo.mysql.AccountService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午8:49:08
* 用户类业务操作
*/
@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;
	
	//注册用户账号
	
	@Override
	public int add(UserAccount account) {
		// TODO Auto-generated method stub
		
		accountDao.insert(account);
		return 0;
	}

	@Override
	public UserAccount queryById(int id) {
		// TODO Auto-generated method stub
		return accountDao.queryById(id);
	}

	//根据条件查询用户是否存在
	@Override
	public UserAccount queryOne(UserAccount account) {
		// TODO Auto-generated method stub
		return accountDao.queryOne(account);
	}
	
	@Override
	public List<UserAccount> query(UserAccount account) {
		// TODO Auto-generated method stub
		return accountDao.query(account);
	}

	@Override
	public void update(UserAccount account) {
		// TODO Auto-generated method stub
		accountDao.update(account);
	}

	@Override
	public void delete(UserAccount account) {
		// TODO Auto-generated method stub
		accountDao.delete(account);
	}

	@Override
	public boolean exsitUser(String username,String type) {
		// TODO Auto-generated method stub
		UserAccount account = new UserAccount();
		switch(type){
		case "mobilephone":
			account.setMobilephone(username);
			break;
		case "email":
			account.setEmail(username);
			break;
		case "username":
			account.setUsername(username);
			break;
		case "workNum":
			account.setWorkNum(username);
			break;
		default:
			break;
			
		}
		
		UserAccount tmp = queryOne(account);
		if(tmp != null){
			return true;
		}
		return false;
	}

	@Override
	public List<UserAccount> showAll() {
		// TODO Auto-generated method stub
		
		return accountDao.showAll();
	}




}
