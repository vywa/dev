package com.hengyun.controller.logininfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.service.logininfo.LoginInfoService;



@Controller
@RequestMapping("reglog")
public class LoginInfoController {

	@Resource
	private LoginInfoService loginInfoService;



	/*
	 *  用户登陆账号
	 *  
	 *  
	 * */
	@RequestMapping("/login")
	@ResponseBody
	public String  login(HttpServletRequest  request,HttpServletResponse response){
		
		 LoginInfo loginInfo = new LoginInfo();
		 
		//String loginname = request.getParameter("loginname");
		//String password = request.getParameter("password");
		//String confirmCode = request.getParameter("confirmCode");
		
		return "loginSuccessCode";
	}
	
	
	/*
	 *  用户退出登陆
	 * */
	@RequestMapping("/logout")
	@ResponseBody

	public String loginout(HttpServletRequest request){
		
	   String token = request.getParameter("token");
	   loginInfoService.logout(token);
	   
	 
	   
	   return "loginoutSuccess";
	
	}
	
}
