package com.hengyun.service.impl.logininfo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.LoginInfoCache;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.logininfo.LoginInfoLogService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;
import com.hengyun.util.randomcode.TockenGenerator;

/*
 *  登陆业务
 * */

public class LoginInfoServiceImpl extends BaseServiceImpl<LoginInfo,Integer> implements LoginInfoService{

	@Resource 
	private LoginInfoDao loginInfoDao;
	
	@Resource 
	private UserAccountService userAccountService;
	
	@Resource 
	private LoginInfoLogService loginInfoLogService;
	
	@Resource
	private UserAccountDao userAccountDao;
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	public List<LoginInfo> getLoginInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *  登陆业务
	 * */
	


	
	/*
	 *  通过用户账号登陆
	 * 
	 * */
	public String loginByUsername(LoginInfo loginInfo, String type) {
		// TODO Auto-generated method stub
	
		
		int code  = userAccountService.validateUserBySign(loginInfo.getLoginUsername(), type,loginInfo.getPassword());
		if(code>0){
			
			Query query = null;
			query = Query.query(Criteria.where("userId").is(code));
			
			LoginInfo temp = new LoginInfo();
			temp = loginInfoDao.queryOne(query);
			
			 if(temp!=null){
				 System.out.println(temp.getUserId());
				 logout(loginInfo.getSessionid());
			 }
			loginInfo.setUserLoginTime(new Date());
			
			String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
			loginInfo.setSessionid(tocken);
			loginInfo.setUserId(code);
			
			loginInfoDao.save(loginInfo);
			
		
			return tocken;
		} else {

			return "failure";
		}
		
	}
	
	/*
	 *  通过存储tocken登陆
	 * 
	 * */
	public boolean loginByTocken(String tocken,LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		if(loginInfoCacheService.loginByTocken(tocken)){
			int userId = loginInfoCacheService.getUserId(tocken);
			loginInfo.setUserId(userId);
			
			loginInfoDao.save(loginInfo);
			return true;
		}
		return false;
	}

	/*
	 *  通过第三方登陆
	 * 
	 * */
	public String  loginByThirdPart(String type,LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		UserAccount userAccount = new UserAccount();
		int userId=0;
			if(type.equals("QQ")){
				userAccount.setQQ(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(userAccount);
			}else if(type.equals("weiChat")){
				userAccount.setWeiChat(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(userAccount);
			} else if(type.equals("weibo")){
				userAccount.setWeiBo(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(userAccount);
			}
			//保存到用户账号数据库
		//	userAccountDao.addUserAccount(userAccount);
			String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
			loginInfo.setUserId(userId);
			loginInfo.setSessionid(tocken);
		loginInfo.setUserLoginTime(new Date());
		loginInfoDao.save(loginInfo);
		return tocken;
	}


	/*
	 *  退出业务
	 * */
	public boolean logout(String tocken) {
		
	//	int userId = loginInfoCacheService.getUserId(tocken);


		Query query = Query.query(Criteria.where("sessionid").is(tocken));
		
		Update update =new Update();
		
		update.unset("sessionid").addToSet("userLogoutTime", new Date());

		loginInfoDao.updateFirst(query, update);
	//	loginInfoCacheService.destroyCache(tocken);
		
		return true;
	}

	public int isOnline(String tocken){
		Query query = null;
		query = Query.query(Criteria.where("sessionid").is(tocken));
		LoginInfo loginInfo = loginInfoDao.queryOne(query);
		if(loginInfo!=null){
			return loginInfo.getUserId();
		} else {
			return -1;
		}
	}
	
	//通过用户id获得tocken
	public String getTockenById(int userId) {
		// TODO Auto-generated method stub
		Query query = null;
		query = Query.query(Criteria.where("userId").is(userId));
		LoginInfo loginInfo = loginInfoDao.queryOne(query);
		String tocken = loginInfo.getSessionid();
		
		return tocken;
	}



}
