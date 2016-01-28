package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.casehistory.CaseHistoryResponse;
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
		caseHistoryService.addCaseHistory(caseHistory);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("add success");
		 return JSON.toJSONString(response);
	}
	
	//条件查询
	@RequestMapping("/dquery")
	@ResponseBody
	public String showdocterCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("docterId").is(docterId));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("query success");
		response.setList(caseHistoryList);
    	  return JSON.toJSONString(response);  
           
	}
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String queryCaseHistory(HttpServletRequest request){
		
		List<CaseHistory> caseHistoryList ;
		caseHistoryList = caseHistoryService.queryAll();

    	 String jsonString= JSON.toJSONString(caseHistoryList);  
           
    	
        return jsonString;  
	}
	
	//条件查询
	@RequestMapping("/query")
	@ResponseBody
	public String showAllCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int patientId = jsonObject.getIntValue("patientId");
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("patientId").is(patientId).andOperator(Criteria.where("docterId").is(docterId)));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("query success");
		response.setList(caseHistoryList);
    	return  JSON.toJSONString(response);  
       
	}
	
	
}
