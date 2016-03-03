package com.hengyun.service.logininfo.mysql;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午8:47:28
* 用户账号业务类
*/
public interface AccountService {
	public int add(UserAccount account);
	
	public UserAccount queryById(int id);
	
	public UserAccount queryOne(UserAccount account);
	
	public List<UserAccount> showAll();
	
	/*
	 * 用户是否存在,返回用户userId
	 * 
	 * */
	public int existUser(String sign,String type);
	
	
	public List<UserAccount> query(UserAccount account);
	
	public void update(UserAccount account);
	
	public void delete(UserAccount account);
	
	//更改密码
	public void updatePassword(String password,int userId) ;

	//注册账号
	public int registerAccount(UserAccount userAccount);
	
	//改变用户找好绑定信息
	public int change(String type,String username,int userId);
	
	//第三方登陆注册
	public int registerThirdAccount(UserAccount userAccount);
	
	//验证用户是否有效,返回用户userId
	public LoginResult validateUserBySign(String sign, String type,String password) ;
	
	//验证第三方用户是否存在
	public UserAccount validateThirdUserBySign(String sign, String type) ;
}
