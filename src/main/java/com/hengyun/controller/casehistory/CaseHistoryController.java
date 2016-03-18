package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.casehistory.response.CaseHistoryResponse;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.CaseHistoryService;

/*
 *  
 *  病历管理，设置控制器
 *  
 * */
@Controller
@RequestMapping("casehistory")
public class CaseHistoryController {
	
	private static final Logger log = LoggerFactory.getLogger(CaseHistoryController.class);
	
	@Resource
	private CaseHistoryService caseHistoryService;
	
	/*
	 * 
	 *  添加病历
	 *  
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addCaseHistory(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistory caseHistory = JSON.toJavaObject(jsonObject, CaseHistory.class);
		caseHistoryService.addCaseHistory(caseHistory);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加病历成功");
		 return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 *  查询某个医生所有病人病历信息
	 *  
	 * */
	@RequestMapping(value="/dquery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showdocterCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("docterId").is(docterId));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("查询病历成功");
		response.setCaseHistoryList(caseHistoryList);
    	  return JSON.toJSONString(response);  
           
	}
	
	/*
	 * 
	 *  显示所有病历
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showAllCaseHistory(HttpServletRequest request){
		
		List<CaseHistory> caseHistoryList ;
		caseHistoryList = caseHistoryService.queryAll();
		CaseHistoryResponse response = new CaseHistoryResponse();
		response.setCode("211");
		response.setMessage("显示病历成功");
    	response.setCaseHistoryList(caseHistoryList);
           
    	
        return  JSON.toJSONString(response);  
	}
	
	/*
	 *  
	 *  查询某个医生的某个病人病历
	 *  
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int patientId = jsonObject.getIntValue("patientId");
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("patientId").is(patientId).andOperator(Criteria.where("docterId").is(docterId)));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("查询病人病历成功");
		response.setCaseHistoryList(caseHistoryList);
    	return  JSON.toJSONString(response);  
       
	}
	
	/*
	 *  
	 *  修改病历信息
	 *  
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int patientId = jsonObject.getIntValue("patientId");
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("patientId").is(patientId).andOperator(Criteria.where("docterId").is(docterId)));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("更新病人病历成功");
		response.setCaseHistoryList(caseHistoryList);
    	return  JSON.toJSONString(response);  
       
	}
	
	/*
	 *  
	 *  设置病历信息
	 *  
	 * */
	@RequestMapping(value="/set",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setCaseHistory(@RequestParam String data, HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		CaseHistoryResponse response = new CaseHistoryResponse();
		int patientId = jsonObject.getIntValue("patientId");
		int docterId = jsonObject.getIntValue("docterId");
		List<CaseHistory> caseHistoryList ;
		Query query = Query.query(Criteria.where("patientId").is(patientId).andOperator(Criteria.where("docterId").is(docterId)));
		caseHistoryList = caseHistoryService.queryList(query);
		response.setCode("211");
		response.setMessage("设置病人病历成功");
		response.setCaseHistoryList(caseHistoryList);
    	return  JSON.toJSONString(response);  
       
	}
}
