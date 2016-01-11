package com.hengyun.controller.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  论坛管理
 * */
@Controller
@RequestMapping("forum")
public class ForumController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addForum(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setForum(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showForum(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	
	
	
}
