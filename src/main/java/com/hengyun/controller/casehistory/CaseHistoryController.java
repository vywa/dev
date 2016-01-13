package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.CaseHistoryService;

/*
 *  病历管理，设置
 * */
@Controller
@RequestMapping("casehistory")
public class CaseHistoryController {
	
	@Resource
	private CaseHistoryService caseHistoryService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addCaseHistory(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistory caseHistory = JSON.toJavaObject(jsonObject, CaseHistory.class);
		caseHistoryService.save(caseHistory);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("add success");
		 return JSON.toJSONString(response);
	}
	
	
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryCaseHistory(HttpServletRequest request){
		
		List<CaseHistory> caseHistoryList ;
		caseHistoryList = caseHistoryService.queryAll();

    	 String jsonString= JSON.toJSONString(caseHistoryList);  
           
    	
        return jsonString;  
	}
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String showAllCaseHistory(HttpServletRequest request){
		
		List<CaseHistory> caseHistoryList ;
		caseHistoryList = caseHistoryService.queryAll();

    	 String jsonString= JSON.toJSONString(caseHistoryList);  
           
    	
        return jsonString;  
	}
	
	
}
