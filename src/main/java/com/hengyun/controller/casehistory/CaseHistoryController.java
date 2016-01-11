package com.hengyun.controller.casehistory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  病历管理，设置
 * */
@Controller
@RequestMapping("casehistory")
public class CaseHistoryController {
	
	@RequestMapping("/add")
	@ResponseBody
	public String addCaseHistory(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setCaseHistory(HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String queryCaseHistory(HttpServletRequest request){
		return null;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateCaseHistory(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
}
