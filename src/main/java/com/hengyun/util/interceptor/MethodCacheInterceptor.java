package com.hengyun.util.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;

/*
 *  方法拦截器
 * */
public class MethodCacheInterceptor implements MethodInterceptor,InitializingBean{

	private static final Logger log = LoggerFactory.getLogger(MethodCacheInterceptor.class);
	
	private Cache cache;
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
