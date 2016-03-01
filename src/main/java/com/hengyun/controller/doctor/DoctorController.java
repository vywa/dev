package com.hengyun.controller.doctor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  医生管理
 * */
@Controller
@RequestMapping("doctor")
public class DoctorController {
	
	
	//管理员添加医生
	@RequestMapping("/add")
	@ResponseBody
	public String addDocter(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteDocter(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String queryDocter(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateDocter(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setDocter(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
}
