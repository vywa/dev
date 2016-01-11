package com.hengyun.controller.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  管理员操作
 * */
@Controller
@RequestMapping("/admin")
public class AdministratorController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addForum(){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setForum(){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showForum(){
		return null;
	}
	
	
	
	
}
