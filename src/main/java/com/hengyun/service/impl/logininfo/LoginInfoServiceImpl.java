package com.hengyun.service.impl.logininfo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.LoginInfoDao;
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
	public int loginByUsername(LoginInfo loginInfo, String type) {
		// TODO Auto-generated method stub
		int code  = userAccountService.validateUserBySign(loginInfo.getLoginUsername(), type,loginInfo.getPassword());
		if(code>0){
			loginInfo.setUserLoginTime(new Date());
			String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
			loginInfo.setSessionid(tocken);
			loginInfo.setUserId(code);
			loginInfoDao.save(loginInfo);
			
			LoginInfoCache loginInfoCache = new LoginInfoCache();
			loginInfoCache.setTocken(tocken);
			loginInfoCache.setUserId(code);
			loginInfoCache.setUsername(loginInfo.getLoginUsername());
			loginInfoCacheService.loadCache(loginInfoCache);
			return code;
		} else {

			return -1;
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
	public boolean  loginByThirdPart(String tocken,LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		loginInfo.setLoginUsername(tocken);
		loginInfo.setUserLoginTime(new Date());
		loginInfoDao.save(loginInfo);
		return true;
	}


	/*
	 *  退出业务
	 * */
	public boolean logout(String tocken) {
		
		int userId = loginInfoCacheService.getUserId(tocken);
		Query query = Query.query(Criteria.where("userId").is(userId));
		Update update =Update.update("sessionId","0");
		
		loginInfoDao.updateFirst(query, update);
		loginInfoCacheService.destroyCache(tocken);
		
		return false;
	}



}
