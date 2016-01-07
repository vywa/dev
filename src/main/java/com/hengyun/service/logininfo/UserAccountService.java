package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.UserAccount;

import com.hengyun.service.BaseService;

public interface UserAccountService  extends BaseService<UserAccount,Integer>{

		public UserAccount getUserAccountById(int id);
		public boolean existUserAccountBySign(String sign);
		public List<UserAccount> getUserAccountALL();
		public void updateUserAccount(UserAccount userAccount) ;
		public int registerAccount(UserAccount userAccount);
}
