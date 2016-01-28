package com.hengyun.util.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.hengyun.util.annotation.Allowed;

//允许通过拦截器
public class AllowedInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		//判断方法是否有allowed注解
		if(invocation.getMethod().isAnnotationPresent(Allowed.class)){
			System.out.println("该方法允许被执行");
		}
		return invocation.proceed();
	}

}
