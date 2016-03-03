package com.hengyun.service.impl.logininfo.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hengyun.dao.logininfo.mysql.AccountDao;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.mysql.AccountService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午8:49:08
* 用户账号类业务操作
*/
@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Resource
	private AccountDao accountDao;
	
	@Resource
	private InformationService informationService;
	/*
	 * 注册用户账号
	 * 
	 * */
	
	@Override
	public int add(UserAccount account) {
		// TODO Auto-generated method stub
		
		accountDao.insert(account);
		account = accountDao.queryOne(account);
		return account.getId();
	}

	
	@Override
	public UserAccount queryById(int id) {
		// TODO Auto-generated method stub
		return accountDao.queryById(id);
	}

	
	/*
	 * 
	 * 根据条件查询用户是否存在
	 * 
	 * */
	@Override
	public UserAccount queryOne(UserAccount account) {
		// TODO Auto-generated method stub
		return accountDao.queryOne(account);
	}
	
	
	@Override
	public List<UserAccount> query(UserAccount account) {
		// TODO Auto-generated method stub
		return accountDao.query(account);
	}

	
	@Override
	public void update(UserAccount account) {
		// TODO Auto-generated method stub
		accountDao.update(account);
	}

	
	@Override
	public void delete(UserAccount account) {
		// TODO Auto-generated method stub
		accountDao.delete(account);
	}

	
	/*
	 * 
	 *  用户是否存在
	 *  
	 * */
	@Override
	public int existUser(String username,String type) {
		// TODO Auto-generated method stub
		UserAccount account = new UserAccount();
		switch(type){
		case "mobilephone":
			account.setMobilephone(username);
			break;
		case "email":
			account.setEmail(username);
			break;
		case "username":
			account.setUsername(username);
			break;
		case "workNum":
			account.setWorkNum(username);
			break;
		default:
			break;
		}
		
		UserAccount tmp = queryOne(account);
		if(tmp != null){
			return tmp.getId();
		}
		return -1;
	}

	/*
	 * 
	 *  显示所有账号
	 * 
	 * */
	@Override
	public List<UserAccount> showAll() {
		// TODO Auto-generated method stub
		
		return accountDao.showAll();
	}

	/*
	 * 
	 * 更新密码
	 * 
	 * */
	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		UserAccount userAccount = new UserAccount();
		userAccount.setPassword(password);
		userAccount.setId(userId);
		accountDao.update(userAccount);
		
	}

	/*
	 * 
	 * 注册用户账号
	 * 
	 * */
	@Override
	public int registerAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		accountDao.insert(userAccount);
		UserAccount user = this.queryOne(userAccount);
		//添加用户个人信息
		Information information = new Information();
		int userId = user.getId();
		informationService.add(information, userId);
		log.info("用户账号注册成功 , "+"身份为: "+userAccount.getCatagory()+" userId为: "+userId);
		
		return userId;
		
	}

	/*
	 * 
	 * 更改用户账号信息
	 * 
	 * */
	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		UserAccount account =new UserAccount();
		account.setId(userId);
		
		if(type.equals("QQ")){
			account.setQQ(username);

		}else if(type.equals("weiChat")){
			account.setWeiChat(username);
		
		} else if(type.equals("weiBo")){
			account.setWeiBo(username);
			
		}else if (type.equals("mobilephone")) {
			 account.setMobilephone(username);
		} else if (type.equals("email")) {
			account.setEmail(username);
		}else if (type.equals("username")) {
			 account.setUsername(username);
		}
		this.update(account);
		log.info("更改用户 "+userId+" 的用户信息成功");
		return 1;
	}

	/*
	 * 
	 * 注册第三方账户
	 * 
	 * */
	@Override
	public int registerThirdAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		//设置病人标志
		userAccount.setCatagory("patient");
		//设置初始密码
		userAccount.setPassword("hengyun");
		return registerAccount(userAccount);
	}

	/*
	 * 
	 * 判断用户身份是否合法
	 * 
	 * */
	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		LoginResult loginResult = new LoginResult();
	
		UserAccount userAccount=new UserAccount();
		userAccount.setPassword(password);
		// 检查是否存在
		if (type.equals("mobilephone")) {
			userAccount.setMobilephone(sign);
			
		} else if (type.equals("email")) {
			userAccount.setEmail(sign);
		} else if (type.equals("username")) {
			userAccount.setUsername(sign);
				
		}if (type.equals("workNum")) {
			userAccount.setWorkNum(sign);
		}
		
		try{
			userAccount = this.queryOne(userAccount);
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

	/*
	 * 
	 *  检测第三方账户是否存在
	 * 
	 * */
	@Override
	public UserAccount validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		UserAccount account=new UserAccount() ;
		
		try{
		if(type.equals("QQ")){
			account.setQQ(sign);
		}else if(type.equals("weiChat")){
			account.setWeiChat(sign);
		} else if(type.equals("weiBo")){
			account.setWeiBo(sign);
		}
		account=this.queryOne(account);
		if(account!=null){
			log.info("第三方账号"+sign+"已经存在");
		}
		} catch(NullPointerException ex){
			log.info("第三方账号 "+sign+" 不存在");
			return null;
		} catch(Exception ex){
			ex.printStackTrace();
		}
	
		return account;
	}

}
