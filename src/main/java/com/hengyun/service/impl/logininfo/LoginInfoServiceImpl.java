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
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoCacheService;

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
	private UserAccountDao userAccountDao;
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	public List<LoginInfo> getLoginInfoAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("sessionid").exists(true));
		return loginInfoDao.queryList(query);
	}

	/*
	 *  登陆业务
	 * */
	


	
	/*
	 *  通过用户账号登陆
	 * 
	 * */
	public LoginResult loginByUsername(LoginInfo loginInfo, String type) {
		// TODO Auto-generated method stub
	
		
		LoginResult loginResult  = userAccountService.validateUserBySign(loginInfo.getLoginUsername(), type,loginInfo.getPassword());
		if(loginResult!=null){
			int userId = Integer.valueOf(loginResult.getCode());
		
				String old = getTockenById(userId);
				if(old!=null){
					logout(old);
				}
				System.out.println(userId+" old "+old);
				loginInfo.setUserLoginTime(new Date());
				
				String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
				
				loginInfo.setSessionid(tocken);
				loginInfo.setUserId(userId);
				loginInfoDao.save(loginInfo);
				loginResult.setMessage(tocken);
				return loginResult;
		}
		return null;
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
	public LoginResult  loginByThirdPart(String type,LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		UserAccount userAccount =null;
		LoginResult loginResult = new LoginResult();
		int userId=0;
			if(type.equals("QQ")){
				userAccount =userAccountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"QQ");
				 if(userAccount==null){
					 UserAccount login = new UserAccount();
					 login.setQQ(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(login);
				loginInfo.setUserId(userId);
				loginResult.setUserCode(3);
				 } else {
					 loginInfo.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
						}
					 if(userAccount.getCatagory().equals("patient")){
						 loginResult.setUserCode(3);
					 } else if(userAccount.getCatagory().equals("doctor"))
					 loginResult.setUserCode(2);
				 }
			}else if(type.equals("weiChat")){
				userAccount =userAccountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"weiChat");
				 if(userAccount==null){
					 UserAccount login = new UserAccount();
					 login.setWeiChat(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(login);
				loginInfo.setUserId(userId);
				loginResult.setUserCode(3);
				 }else {
					 loginInfo.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
						}
					 if(userAccount.getCatagory().equals("patient")){
						 loginResult.setUserCode(3);
					 } else if(userAccount.getCatagory().equals("doctor"))
					 loginResult.setUserCode(2);
				 }
			} else if(type.equals("weiBo")){
				userAccount =userAccountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"weiBo");
				 if(userAccount==null){
					 UserAccount login = new UserAccount();
					 login.setWeiBo(loginInfo.getLoginUsername());
				userId = userAccountService.registerThirdAccount(login);
				loginInfo.setUserId(userId);
				loginResult.setUserCode(3);
				 }else {
					 loginInfo.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
						}
					 if(userAccount.getCatagory().equals("patient")){
						 loginResult.setUserCode(3);
					 } else if(userAccount.getCatagory().equals("doctor"))
					 loginResult.setUserCode(2);
				 }
			}
			
			String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
		
			loginInfo.setSessionid(tocken);
			loginInfo.setUserLoginTime(new Date());
			
			
			loginInfoDao.save(loginInfo);
			loginResult.setMessage(tocken);
		
			return loginResult;
	}


	/*
	 *  退出业务
	 * */
	public boolean logout(String tocken) {
		
	//	int userId = loginInfoCacheService.getUserId(tocken);


		Query query = Query.query(Criteria.where("sessionid").exists(true).andOperator(Criteria.where("sessionid").is(tocken)));
		
		Update update =new Update();
		
		update.unset("sessionid").addToSet("userLogoutTime", new Date());

		loginInfoDao.updateFirst(query, update);
	//	loginInfoCacheService.destroyCache(tocken);
		
		return true;
	}

	//判断用户是否在线
	public int isOnline(String tocken){
		Query query =new Query();
		query = Query.query(Criteria.where("sessionid").exists(true).andOperator(Criteria.where("sessionid").is(tocken)));
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
		
		Query query = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("sessionid").exists(true)));
		LoginInfo loginInfo = loginInfoDao.queryOne(query);
		if(loginInfo!=null){
		
		System.out.println(loginInfo.toString());
	
		return loginInfo.getSessionid();
		} else {
			return null;
		}
	}



}
