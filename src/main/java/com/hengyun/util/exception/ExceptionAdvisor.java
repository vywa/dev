package com.hengyun.util.exception;


import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.hengyun.controller.exception.ControllerAccessBusinessException;
import com.hengyun.dao.exception.DBException;
import com.hengyun.service.exception.BusinessDataAccessException;
import com.hengyun.service.exception.ThealthBusinessException;


public class ExceptionAdvisor implements ThrowsAdvice
{
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable
	{
		
		Logger log = Logger.getLogger(target.getClass());
		StringBuffer buffer = new StringBuffer();
		buffer.append(" 错误放生在类 :");
		buffer.append(target.getClass().getName());
		buffer.append(" 方法为 :");
		buffer.append( target.getClass().getName());
		
			for (int i = 0; i < args.length; i++)
			{
				buffer.append(" 参数"+i+"为"+args[i]);
			}
		buffer.append(" 异常信息为: "+ex.getMessage());
		String detail = buffer.toString();
		log.info(detail);
		
		 if(ex instanceof DBException){
             throw new BusinessDataAccessException(((DBException) ex).getCode(),ex.getMessage(),ex.getCause());
     } else if(ex instanceof ThealthBusinessException){
             throw new ControllerAccessBusinessException(((ThealthBusinessException) ex).getCode(),ex.getMessage(),ex.getCause());
     }

	}
}