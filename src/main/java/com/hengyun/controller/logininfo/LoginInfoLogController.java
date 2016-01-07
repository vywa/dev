package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.domain.loginInfo.LoginInfoLog;
import com.hengyun.service.logininfo.LoginInfoLogService;



@Controller
@RequestMapping("LoginLog")
public class LoginInfoLogController {

	@Resource
	private LoginInfoLogService loginInfoLogService;



	/*
	 *  用户登陆日志查询
	 *  
	 *  
	 * */
	@RequestMapping("/show")
	@ResponseBody
	public String  showLog(HttpServletRequest  request,HttpServletResponse response){
		
		
		List<LoginInfoLog> logList = loginInfoLogService.getLoginInfoAll(); 
		return JSON.toJSONString(logList);
	}
	
	
	
}
