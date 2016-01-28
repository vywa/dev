package com.hengyun.dao.logininfo.mysql;

import java.util.List;

import com.hengyun.domain.loginInfo.UserAccount;

//mysql用户账号操作接口
public interface UserAccountDao {

	public UserAccount queryById(int id);
	
	public List<UserAccount> query(UserAccount userAccount);
	
	public void insert(UserAccount userAccount);
	
	public void delete(UserAccount userAccount);
	
	public void update(UserAccount userAccount);
}
