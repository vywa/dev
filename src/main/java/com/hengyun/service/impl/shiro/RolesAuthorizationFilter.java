package com.hengyun.service.impl.shiro;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

/*
 *   自定义角色鉴权过滤器（满足其中一个角色则通过）
 *   
 *   扩展异步请求(ajax)认证提示功能
 * */
public class RolesAuthorizationFilter extends AuthorizationFilter{

	public RolesAuthorizationFilter(){}

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {  
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		Subject subject = getSubject(request,response);
		if(subject.getPrincipal() == null){
			if(true){
				
			} else {
				saveRequestAndRedirectToLogin(request,response);
			}
		} else {
			if(false){
				
			} else {
				String unauthorizedUrl = getUnauthorizedUrl();
				if(StringUtils.hasText(unauthorizedUrl)){
					WebUtils.issueRedirect(httpRequest, httpResponse, unauthorizedUrl);
				} else {
					WebUtils.toHttp(httpResponse).sendError(404);
				}
			}
		}
		return false;
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
		Subject subject = getSubject(request,response);
		
		String rolesArray[] = (String[])(String[])mappedValue;
		if(rolesArray == null || rolesArray.length == 0){
			return true;
		}
		
			Set<String> roles = CollectionUtils.asSet(rolesArray);
			//满足任一个角色即可放行
			for(String role : roles){
				if(subject.hasRole(role)){
					return true;
				}
			}
			return false;
		
	
	}
	
	
}
