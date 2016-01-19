package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.BaseService;

public interface UserAccountService  extends BaseService<UserAccount,Integer>{

		public UserAccount getUserAccountById(int id);
		public boolean existUserAccountBySign(String sign,String type);
		public int existUser(String sign,String type);
		
		public List<UserAccount> getUserAccountALL();
		public void updateUserAccount(UserAccount userAccount) ;

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
