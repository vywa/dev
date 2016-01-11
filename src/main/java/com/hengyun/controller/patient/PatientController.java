package com.hengyun.controller.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  医生管理
 * */
@Controller
@RequestMapping("patient")
public class PatientController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addPatient(){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setPatient(){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String queryPatient(){
		return null;
	}
	
	
	
	
}
