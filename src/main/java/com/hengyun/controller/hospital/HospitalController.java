package com.hengyun.controller.hospital;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  医院管理
 * 
 * */
@Controller
@RequestMapping("hospital")
public class HospitalController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addHospital(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setHospital(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryHospital(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editHospital(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	
}
