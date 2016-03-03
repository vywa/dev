package com.hengyun.service.impl.logininfo.mysql;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.ThirdLoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.logininfo.mysql.AccountService;
import com.hengyun.service.logininfo.mysql.LoginService;
import com.hengyun.util.randomcode.TockenGenerator;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月2日 上午9:27:55
* 登陆业务实现类
*/
@Service
public class LoginServiceImpl implements LoginService{

	 private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	 
	@Resource
	private LoginInfoDao loginInfoDao;
	
	@Resource
	private AccountService accountService;
	
	@Resource
	private LoginInfoCacheService loginInfoCacheService;

	/*
	 * 
	 * 查询所有登陆账户
	 * 
	 * */
	@Override
	public List<LoginInfo> getLoginInfoAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("sessionid").exists(true));
		return loginInfoDao.queryList(query);
	}

	/*
	 * 
	 * 用户名，手机号，邮箱登陆
	 * 
	 * */
	@Override
	public LoginResult loginByUsername(LoginInfo loginInfo, String type) {
		// TODO Auto-generated method stub
		LoginResult loginResult  = accountService.validateUserBySign(loginInfo.getLoginUsername(), type,loginInfo.getPassword());
		if(loginResult!=null){
			int userId = Integer.valueOf(loginResult.getUserId());
		
				String old = getTockenById(userId);
				//检测用户是否登陆，已经登陆，则使其退出
				if(old!=null){
					logout(old);
					log.debug(old + " 对应的用户 "+ userId + "已经退出");
				}
			
				loginInfo.setUserLoginTime(new Date());
				 if(loginResult.getUserCode()==3){
					 loginInfo.setCatagory("patient");
				 } else if(loginResult.getUserCode()==2){
					 loginInfo.setCatagory("doctor");
				 }else if(loginResult.getUserCode()==1){
					 loginInfo.setCatagory("admin");
				 }
				String tocken = TockenGenerator.generate(loginInfo.getLoginUsername());
				
				loginInfo.setSessionid(tocken);
				loginInfo.setUserId(userId);
				loginInfoDao.save(loginInfo);
				log.info("用户: "+userId+" 账号: "+loginInfo.getLoginUsername()+" 登陆成功");
				loginResult.setMessage(tocken);
				loginResult.setType(type);
				loginResult.setLoginName(loginInfo.getLoginUsername());
				return loginResult;
		}
		return null;
	}

	/*
	 * 
	 * 通过tocken登陆
	 * 
	 * */
	@Override
	public boolean loginByTocken(String tocken, LoginInfo loginInfo) {
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
	 * 
	 *  三方登陆
	 * 
	 * */
	@Override
	public LoginResult loginByThirdPart(String type, LoginInfo loginInfo) {
		// TODO Auto-generated method stub
		UserAccount userAccount =null;
		ThirdLoginResult loginResult = new ThirdLoginResult();
		int userId=0;
		//QQ第三方登陆
			if(type.equals("QQ")){
				userAccount =accountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"QQ");
				 if(userAccount==null){
					 //用户不存在
					 UserAccount login = new UserAccount();
					 login.setQQ(loginInfo.getLoginUsername());
				
				userId = accountService.registerThirdAccount(login);
				log.info("注册QQ账号: "+loginInfo.getLoginUsername()+"成功,用户id为: "+userId);
				loginInfo.setUserId(userId);
				loginResult.setUserCode(3);
				loginResult.setUserId(userId);
				loginResult.setRegister("register");
				
				 } else {
					
					 loginInfo.setUserId(userAccount.getId());
					 
					 loginResult.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
							log.debug("用户 "+userAccount.getId() +" 成功退出!");
						}
					 if(userAccount.getCatagory().equals("patient")){
						 loginResult.setUserCode(3);
					 } else if(userAccount.getCatagory().equals("doctor"))
					 loginResult.setUserCode(2);
				 }
			}else if(type.equals("weiChat")){
				userAccount =accountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"weiChat");
				 if(userAccount==null){
					 UserAccount login = new UserAccount();
					 login.setWeiChat(loginInfo.getLoginUsername());
				userId = accountService.registerThirdAccount(login);
				log.info("注册微信账号: "+loginInfo.getLoginUsername()+"成功,用户id为: "+userId);
				loginInfo.setUserId(userId);
				loginResult.setUserId(userId);
				loginResult.setUserCode(3);
				loginResult.setRegister("register");
				 }else {
					 loginInfo.setUserId(userAccount.getId());
					 loginResult.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
							log.debug("用户 "+userAccount.getId() +" 成功退出!");
						}
					 if(userAccount.getCatagory().equals("patient")){
						 loginResult.setUserCode(3);
					 } else if(userAccount.getCatagory().equals("doctor"))
					 loginResult.setUserCode(2);
				 }
			} else if(type.equals("weiBo")){
				userAccount =accountService.validateThirdUserBySign(loginInfo.getLoginUsername(),"weiBo");
				 if(userAccount==null){
					 UserAccount login = new UserAccount();
					 login.setWeiBo(loginInfo.getLoginUsername());
				userId = accountService.registerThirdAccount(login);
				log.info("注册微博账号: "+loginInfo.getLoginUsername()+"成功,用户id为: "+userId);
				loginInfo.setUserId(userId);
				loginResult.setUserId(userId);
				loginResult.setUserCode(3);
				loginResult.setRegister("register");
				 }else {
					 loginInfo.setUserId(userAccount.getId());
					 loginResult.setUserId(userAccount.getId());
						String old = getTockenById(userAccount.getId());
						if(old!=null){
							logout(old);
							log.debug("用户 "+userAccount.getId() +" 成功退出!");
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
			
			//保存登陆信息
			loginInfoDao.save(loginInfo);
			//Query query = Query.query(Criteria.where("_id").is(loginInfo.getUserId()));
			UserAccount account = new UserAccount();
			account.setId(userId);
			 account = accountService.queryOne(account);
			String password = account.getPassword();
		
			loginResult.setPassword(password);
			loginResult.setMessage(tocken);
		
			return loginResult;
	}

	/*
	 * 
	 *  通过id找到用户tocken
	 * 
	 * */
	@Override
	public String getTockenById(int userId) {
		// TODO Auto-generated method stub
		
		Query query = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("sessionid").exists(true)));
		LoginInfo loginInfo = loginInfoDao.queryOne(query);
		if(loginInfo!=null){
		
	
		return loginInfo.getSessionid();
		} else {
			return null;
		}
	}

	/*
	 * 
	 *  检测该tocken是否登陆
	 * 
	 * */
	@Override
	public int isOnline(String tocken) {
		// TODO Auto-generated method stub
		Query query =new Query();
		query = Query.query(Criteria.where("sessionid").exists(true).andOperator(Criteria.where("sessionid").is(tocken)));
		LoginInfo loginInfo = loginInfoDao.queryOne(query);
		if(loginInfo!=null){
			return loginInfo.getUserId();
		} else {
			//log.info("用户已经退出");
			return -1;
		}
	}

	/*
	 * 
	 *  用户退出系统
	 * 
	 * */
	@Override
	public boolean logout(String tocken) {
		// TODO Auto-generated method stub
//		int userId = loginInfoCacheService.getUserId(tocken);

			Query query = Query.query(Criteria.where("sessionid").exists(true).andOperator(Criteria.where("sessionid").is(tocken)));
			
			Update update =new Update();
			
			update.unset("sessionid").addToSet("userLogoutTime", new Date());
			//更新用户登陆状态为失效
			loginInfoDao.updateFirst(query, update);
			
		//	loginInfoCacheService.destroyCache(tocken);
			
			return true;
	}
	

}
