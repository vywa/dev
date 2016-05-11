package com.hengyun.service.logininfo;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.util.SpringTest;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月9日 下午5:41:29
* 类说明
*/
public class LoginInfoServiceTest extends SpringTest {

	@Resource 
	private LoginInfoDao loginInfoDao;
	
	@Resource 
	private UserAccountService userAccountService;

	@Resource
	private UserAccountDao userAccountDao;
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	
	//医生登陆
		@Test
		public void doctorLogin() {
			// TODO Auto-generated method stub
			String username="10001";
			String type="workNum";
			 String password="654321";
			int userId = userAccountService.validateUser(username, type, password);
			Assert.assertEquals(userId, 1000000044);
			
		}
		@Test
		public void getTockenById() {
			// TODO Auto-generated method stub
			int userId = 1000000044;
			String tocken=loginInfoService.getTockenById(userId);
			
		//	Assert.assertEquals(1000000044, loginInfoCacheService.isOnline(tocken));
			
		}
}
