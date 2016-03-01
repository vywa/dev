package com.hengyun.util.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 下午6:40:27
* 验证码表单提交认证过滤器
*/
public class CodeFormAuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger log = LoggerFactory.getLogger(CodeFormAuthenticationFilter.class);
	
	public CodeFormAuthenticationFilter(){}
	
	/*登陆验证*/
	protected boolean executeLogin(ServletRequest request,ServletResponse response) throws Exception{
		CodeUsernamePasswordTocken tocken = createTocken(request, response);
		return false;
	}
	
	/*创建tocken*/
	protected CodeUsernamePasswordTocken createTocken(ServletRequest request,ServletResponse response){
		return null;
	}
	
	/*验证码效验*/
	protected void setFailureAttribute(ServletRequest request,AuthenticationException ae){
		
	}
}
