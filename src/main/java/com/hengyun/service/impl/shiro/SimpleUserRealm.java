package com.hengyun.service.impl.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.service.shiro.SimpleCacheManager;

/*
 *  安全框架桥接器
 * */
public class SimpleUserRealm extends AuthorizingRealm{

	private final static Logger log = LoggerFactory.getLogger(SimpleUserRealm.class);
/*	
	@Resource
	private UserDetailsService userDetailService;
	@Resource
	private AuthorityService authorityService;
	*/
	@Resource
	private SimpleCacheManager simpleCacheManager;
	
	//授权当前用户信息
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipals){
		return getAuthorizationInfo(pricipals.getPrimaryPrincipal());
	}
	
	private SimpleAuthorizationInfo getAuthorizationInfo(Object principal){
		//List<Authority> authorities = null;
		//获取缓存，如果失败则返回空角色集合
		try {
			 simpleCacheManager.getCache(principal.toString());
		} catch (CacheException e) {
			// TODO Auto-generated catch block
			//authorities = new ArrayList<Authority>();
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//添加角色到安全认证体系
		/*
		for(Authority authority : authorities){
			authorizationInfo.addRole(authority.getName());
		}
*/
		return authorizationInfo;
	}
	
	//用户登陆认证
	protected AuthenticationInfo 	doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException{
		UsernamePasswordToken  token = (UsernamePasswordToken)authcToken;
		return null;
	
		
	}
	
	//加载用户角色
	/*
	private void loadUserAuthorityTocache(UserDetails details){
		
	}
	*/
	//重写退出时缓存处理方法
	protected void doClearCache(PrincipalCollection principalcollection){
		
	}
}
