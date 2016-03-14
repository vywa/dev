package com.hengyun.util.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hengyun.service.administrator.ResourcesService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午6:27:33
* 权限检查过滤器
*/
public class AuthenticateInterceptor implements HandlerInterceptor{

	private static final Logger log = LoggerFactory.getLogger(AuthenticateInterceptor.class);
	
	@Resource 
	private ResourcesService resourcesService;
	
	/*
	 * 检查用户对该资源是否有权限操作
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			int userId = (int)request.getAttribute("userId");
			String requestUrl = request.getServletPath();
			log.info("当前请求的地址是: "+requestUrl+",用户是: "+userId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("no user");
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
