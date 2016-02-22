package com.hengyun.controller.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  管理员操作
 * */
@Controller
@RequestMapping("admin")
public class AdministratorController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addForum(){
		
		return null;
	}
	
	//管理员登陆
	@RequestMapping("/login")
	@ResponseBody
	public String adminLogin(){
		
		return "manager";
	}
	
	//登陆首页
	@RequestMapping("/home")
	@ResponseBody
	public String home(){
		return null;
	}
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String showForum(){
		return null;
	}
	
	
	
	
}
