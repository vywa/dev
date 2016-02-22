package com.hengyun.util.log;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月22日 下午1:48:08
* 日志处理
*/
public class LogInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invoke) throws Throwable {
		// TODO Auto-generated method stub
		Object[] object = invoke.getArguments();
		
		try {
		
			String date = new Date().toLocaleString();
			PlatformLogger.info("开始时间"+date);
			Object returnObject = invoke.proceed();
			
			String date2 = new Date().toLocaleString();
			PlatformLogger.info("结束时间"+date2);
			return returnObject;
		} catch (Throwable throwable) {
			// TODO Auto-generated catch block
			throwable.printStackTrace();
		}
		return null;
	}

}
