package com.hengyun.service.logininfo.mysql;

import java.util.List;

import com.hengyun.domain.loginInfo.UserAccount;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午8:47:28
* 用户类
*/
public interface AccountService {
	public int add(UserAccount account);
	
	public UserAccount queryById(int id);
	
	public UserAccount queryOne(UserAccount account);
	
	public List<UserAccount> showAll();
	
	//用户是否存在
	public boolean exsitUser(String sign,String type);
	
	public List<UserAccount> query(UserAccount account);
	
	public void update(UserAccount account);
	
	public void delete(UserAccount account);
}
