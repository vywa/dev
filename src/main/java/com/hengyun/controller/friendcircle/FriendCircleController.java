package com.hengyun.controller.friendcircle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  朋友圈管理
 * */
@Controller
@RequestMapping("circle")
public class FriendCircleController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addCircle(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setCircle(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryCircle(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editCircle(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	
	
	
}
