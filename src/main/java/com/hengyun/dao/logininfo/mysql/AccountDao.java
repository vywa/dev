package com.hengyun.dao.logininfo.mysql;

import java.util.List;

import com.hengyun.domain.loginInfo.UserAccount;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午6:35:25
* 用户账号数据访问接口
*/
public interface AccountDao {

	public UserAccount queryById(int id);
	
	public UserAccount queryOne(UserAccount userAccount);
	
	public List<UserAccount> showAll();
	
	public List<UserAccount> query(UserAccount userAccount);
	
	public void insert(UserAccount userAccount);
	
	public void delete(UserAccount userAccount);
	
	public void update(UserAccount userAccount);
}
