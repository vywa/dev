package com.hengyun.util.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.util.regex.Validator;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月20日 下午4:36:45
* 管理员认证类
*/
public class MongodbRealm implements Realm {

	@Resource 
	private UserAccountDao userAccountDao;

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken tocken) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获取用户名和密码
		String username = (String)tocken.getPrincipal();
		String password = new String((char[])tocken.getCredentials());
		Query query = null;
		if(Validator.isPassword(password)){
			//密码错误
			throw new IncorrectCredentialsException(); 
		}
		
		if(Validator.isUsername(username)){
			query = Query.query(Criteria.where("username").is(username).andOperator(Criteria.where("username").exists(true)).
					andOperator(Criteria.where("password").is(password).andOperator(Criteria.where("password").exists(true))));
		} else if(Validator.isEmail(username)){
			query = Query.query(Criteria.where("email").is(username).andOperator(Criteria.where("email").exists(true)).
					andOperator(Criteria.where("password").is(password).andOperator(Criteria.where("password").exists(true))));
		} else if(Validator.isMobile(username)){
			query = Query.query(Criteria.where("mobilephone").is(username).andOperator(Criteria.where("mobilephone").exists(true)).
					andOperator(Criteria.where("password").is(password).andOperator(Criteria.where("password").exists(true))));
		}
		UserAccount 	userAccount = userAccountDao.queryOne(query);
		if(userAccount != null){
			//如果身份认证成功，返回一个AuthenticationInfo实现　
			return new SimpleAuthenticationInfo(username, password, getName());  
		} else {
			//抛出密码错误异常
			throw new IncorrectCredentialsException();
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "hengyunReaml";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		//仅支持usernamePasswordTocken类型的Tocken
		return token instanceof UsernamePasswordToken; 
	}
	
	
}
