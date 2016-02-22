package com.hengyun.util.interceptor;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.hengyun.service.logininfo.LoginInfoCacheService;

/*
 *  缓存设置拦截器
 * */

public class MethodCacheInterceptor implements MethodInterceptor,InitializingBean{

	private static final Logger log = LoggerFactory.getLogger(MethodCacheInterceptor.class);
	
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		return null;
	}

	
}
