package com.hengyun.service.impl.logininfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.logininfo.UserAccountService;

public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount, Integer> implements UserAccountService {

	private static final Logger log = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	
	@Resource
	private UserAccountDao userAccountDao;

	@Resource
	private IndexCollectionDao indexCollectionDao;
					
	@Resource
	private RegisterCacheService registerCacheService;

	@Resource
	private InformationService informationService;
	
	public UserAccount getUserAccountById(int id) {
		// TODO Auto-generated method stub
		return userAccountDao.queryById(id);
	}

	// 获取所有用户账号
	public List<UserAccount> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("_id").exists(true));
		return userAccountDao.queryList(query);
	}

	// 注册账号
	public int registerAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		//添加用户，返回用户的id
			int userId =0;
			// 根据类型，自增索引
			if(userAccount.getCatagory().equals("patient")){
				userId = indexCollectionDao.updateIndex("patient");
				userAccount.setId(userId);
			} else if(userAccount.getCatagory().equals("doctor")) {
				userId = indexCollectionDao.updateIndex("doctor");
				userAccount.setId(userId);
				userAccount.setPassword("123456");
			}else if(userAccount.getCatagory().equals("admin")) {
				userId = indexCollectionDao.updateIndex("admin");
				userAccount.setId(userId);
				}
			userAccountDao.save(userAccount);
			//添加用户个人信息
		//	Information information = new Information();
		//	information.setMobilephone(userAccount.getMobilephone());
		//	informationService.add(information, userId);
			log.info("用户账号注册成功 , "+"身份为: "+userAccount.getCatagory()+" userId为: "+userId);
			return userId;
	
	}

	// 更新密码
	public void updatePassword(String password,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		Update update = Update.update("password", password);
		userAccountDao.updateFirst(query, update);

	}

	// 用户是否存在
	public boolean existUserAccountBySign(String sign, String type) {
		// TODO Auto-generated method stub
		
		Query query = null;
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("mobilephone").exists(true)));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("email").exists(true)));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("username").exists(true)));
		} else if(type.equals("workNum")){
			query = Query.query(Criteria.where("workNum").is(sign).andOperator(Criteria.where("workNum").exists(true)));
		}
		UserAccount userAccount = userAccountDao.queryOne(query);
		
		
		try{
		if(userAccount!=null){
			return true;
		} else {
			return false;
		}
		
		} catch(NullPointerException ex){
			return false;
		}

	}

	// 用户是否存在
		public int existUser(String sign, String type) {
			// TODO Auto-generated method stub
			UserAccount userAccount=null;
			Query query = null;
			if (type.equals("mobilephone")) {
				query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("mobilephone").exists(true)));
			} else if (type.equals("email")) {
				query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("email").exists(true)));
			} else if (type.equals("username")) {
				query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("username").exists(true)));
			} else if(type.equals("workNum")){
				query = Query.query(Criteria.where("workNum").is(sign).andOperator(Criteria.where("workNum").exists(true)));
			} 
			
			try{
			 userAccount = userAccountDao.queryOne(query);
			 if(userAccount == null){
				 return -1;
			 }
				return userAccount.getId();
			} catch(NullPointerException ex){
				log.info(sign+" 账号不存在");
				return -1;
			} catch(Exception ex){
				ex.printStackTrace();
			}
			return -1;
		}
	
		
	// 判断用户身份是否合法
	public LoginResult validateUserBySign(String sign, String type,String password) {
		// TODO Auto-generated method stub
		LoginResult loginResult = new LoginResult();
		Query query = null;
		UserAccount userAccount=null;
		// 检查是否存在
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("password").is(password)));
				
		}if (type.equals("workNum")) {
			query = Query.query(Criteria.where("workNum").is(sign).andOperator(Criteria.where("password").is(password)));
		}
		
		try{
			userAccount = userAccountDao.queryOne(query);
			if(userAccount!=null){
				log.info("用户: "+sign+"登陆成功");
			}
		} catch(NullPointerException ex){
			log.error("用户: "+sign+" 密码: "+password+" 验证失败");
			return null;
		}
			int userId = userAccount.getId();
			
			loginResult.setUserId(userId);
			if(userAccount.getCatagory().equals("doctor")){
				loginResult.setUserCode(2);
			} else if(userAccount.getCatagory().equals("patient")) {
				loginResult.setUserCode(3);
			}	else if(userAccount.getCatagory().equals("admin")){
				loginResult.setUserCode(1);
			} else if(userAccount.getCatagory().equals("root")){
				loginResult.setUserCode(0);
			} else if(userAccount.getCatagory().equals("third")) {
				loginResult.setUserCode(4);
			} else {
				loginResult.setUserCode(5);					//游客???
			}
	
	
		return loginResult;
	}

	public int registerThirdAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		
		//设置病人标志
		userAccount.setCatagory("patient");
		//设置初始密码
		userAccount.setPassword("123456");
		return registerAccount(userAccount);
	
	}

	//检查第三方账号是否存在
	public UserAccount validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		UserAccount userAccount=null ;
	
		try{
		if(type.equals("QQ")){
			Query query = Query.query(Criteria.where("QQ").is(sign).andOperator(Criteria.where("QQ").exists(true)));
			userAccount = userAccountDao.queryOne(query);
		}else if(type.equals("weiChat")){
			Query query = Query.query(Criteria.where("weiChat").is(sign).andOperator(Criteria.where("weiChat").exists(true)));
			userAccount = userAccountDao.queryOne(query);
		} else if(type.equals("weiBo")){
			Query query = Query.query(Criteria.where("weiBo").is(sign).andOperator(Criteria.where("weiBo").exists(true)));
			userAccount = userAccountDao.queryOne(query);
		}
		if(userAccount!=null){
			System.out.println("三方用户已经存在");
		}
		} catch(NullPointerException ex){
			log.info("第三方账号 "+sign+" 不存在");
			return null;
		} catch(Exception ex){
			ex.printStackTrace();
		}
	
		return userAccount;
	}

	//更改用户对应的信息
	public int change(String type, String sign,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("_id").is(userId));
		Update update =new Update();
		if(type.equals("QQ")){
			if(sign==null){
				update=update.unset("QQ");
			}else {
				 update= update.set("QQ", sign);
			}
			
		}else if(type.equals("weiChat")){
			if(sign==null){
				update=update.unset("weiChat");
			}else {
				 update= update.set("weiChat", sign);
			}
		
		} else if(type.equals("weiBo")){
			if(sign==null){
				update=update.unset("weiBo");
			}else {
				 update= update.set("weiBo", sign);
			}
			
		}else if (type.equals("mobilephone")) {
			if(sign==null){
				update=update.unset("mobilephone");
			}else{
				 update= update.set("mobilephone", sign);
			}
		} else if (type.equals("email")) {
			if(sign==null){
				update=update.unset("email");
			}else{
				 update= update.set("email", sign);
			}
		}else if (type.equals("username")) {
			if(sign==null){
				update=update.unset("username");
			} else {
				 update= update.set("username", sign);
			}
		}
		userAccountDao.updateFirst(query, update);
		log.info("更改用户 "+userId+" 的用户信息成功");
		return 1;
	}

	//更改用户对应的信息
	public int unbind(String type, String sign,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(userId));
		Update update =null;
		if(type.equals("QQ")){
		
			 update= Update.update("QQ", sign);
			
		}else if(type.equals("weiChat")){
			 update= Update.update("weiChat", sign);
		
		} else if(type.equals("weiBo")){
			 update= Update.update("weiBo", sign);
			
		}else if (type.equals("mobilephone")) {
			 update= Update.update("mobilephone", sign);
		} else if (type.equals("email")) {
			 update= Update.update("email", sign);
		}else if (type.equals("username")) {
			 update= Update.update("username", sign);
		}
		userAccountDao.updateFirst(query, update);
		log.info("更改用户 "+userId+" 的用户信息成功");
		return 1;
	}

	/*
	 *  绑定亲情号
	 * 
	@Override
	public void bindFriend(int userId,int friendId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(userId));
		UserAccount account = userAccountDao.queryOne(query);
		List<Integer> friendList = account.getFriendList();
		if(friendList==null){
			friendList = new ArrayList<Integer>();
			friendList.add(friendId);
		} else {
			friendList.add(friendId);
		}
		Update update = Update.update("friendList", friendList);
		userAccountDao.updateFirst(query, update);
	}*/

	@Override
	public int validateUser(String sign, String type, String password) {
		// TODO Auto-generated method stub
		Query query = null;
		UserAccount userAccount=null;
		// 检查是否存在
		if (type.equals("mobilephone")) {
			query = Query.query(Criteria.where("mobilephone").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("email")) {
			query = Query.query(Criteria.where("email").is(sign).andOperator(Criteria.where("password").is(password)));
		} else if (type.equals("username")) {
			query = Query.query(Criteria.where("username").is(sign).andOperator(Criteria.where("password").is(password)));
				
		}if (type.equals("workNum")) {
			query = Query.query(Criteria.where("workNum").is(sign).andOperator(Criteria.where("password").is(password)));
		}
		
		try{
			userAccount = userAccountDao.queryOne(query);
			return userAccount.getId();
		} catch(NullPointerException ex){
			
			return -1;
		}
			
	}

	@Override
	public void bindFriend(int userId, int friendId) {
		// TODO Auto-generated method stub
		
	}


}
