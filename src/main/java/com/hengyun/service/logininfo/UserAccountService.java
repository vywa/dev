package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.UserAccount;

import com.hengyun.service.BaseService;

public interface UserAccountService  extends BaseService<UserAccount,Integer>{

		public UserAccount getUserAccountById(int id);
		public boolean existUserAccountBySign(String sign,String type);
		public List<UserAccount> getUserAccountALL();
		public void updateUserAccount(UserAccount userAccount) ;

		public int registerAccount(UserAccount userAccount);
		//验证用户是否有效,返回用户userId
		public int validateUserBySign(String sign, String type,String password) ;
}
