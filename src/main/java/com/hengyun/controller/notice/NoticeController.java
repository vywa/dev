package com.hengyun.controller.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 *  消息管理
 *  
 * */

@Controller
@RequestMapping("notice")
public class NoticeController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addNotice(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setNotice(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryNotice(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editNotice(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	
	
	
}
