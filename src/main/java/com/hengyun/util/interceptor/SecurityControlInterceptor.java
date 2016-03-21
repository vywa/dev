package com.hengyun.util.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.util.annotation.SecurityControl;
import com.hengyun.util.security.SecurityControlHolder;

//允许通过拦截器
public class SecurityControlInterceptor implements MethodInterceptor{

	private static final Logger log = LoggerFactory.getLogger(SecurityControlInterceptor.class);
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Method method = invocation.getMethod();
		Class<?> clazz = method.getDeclaringClass();
		SecurityControl sc = clazz.getAnnotation(SecurityControl.class);
		//安全验证
		SecurityControlHolder.checkPermission(sc);
		
		return invocation.proceed();
	}

}
