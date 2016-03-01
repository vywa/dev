package com.hengyun.util.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 下午5:30:00
* 角色过滤器
*/
public class CustomRolesAuthorizationFileter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
		Subject subject = getSubject(request,response);
		String[] rolesArray = (String[])mappedValue;
		if(rolesArray == null || rolesArray.length==0){
			return true;
		} 
		//有某个角色符合就可以通过
		for(int i=0;i<rolesArray.length;i++){
			if(subject.hasRole(rolesArray[i])){
				return true;
			}
		}
		return false;
	}

}
