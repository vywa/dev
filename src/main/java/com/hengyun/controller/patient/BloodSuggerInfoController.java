package com.hengyun.controller.patient;


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
import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.domain.patient.HealthInfoResponse;
import com.hengyun.domain.patient.HealthLine;
import com.hengyun.domain.patient.HealthTarget;
import com.hengyun.domain.patient.SuggerResponse;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.patient.BloodSuggerInfoService;
import com.hengyun.service.patient.HealthLineService;
import com.hengyun.service.patient.HealthTargetService;

/*
 * 
 *  血糖操作
 * */
@Controller
@RequestMapping("bloodSugger")
public class BloodSuggerInfoController {

	 private static final Logger log = LoggerFactory.getLogger(BloodSuggerInfoController.class);
	@Resource
	private BloodSuggerInfoService  bloodSuggerInfoService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	@Resource
	private HealthTargetService healthTargetService;
	
	@Resource
	private HealthLineService healthLineService;
	
	/*
	 * 
	 *   查询用户特定时间段血糖数据
	 * 
	 * */
	
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBloodSugger(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
			
		SuggerResponse sugger = new SuggerResponse();
		int userId =(int)request.getAttribute("userId");
	
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");

		List<BloodSuggerInfo> bloodList = bloodSuggerInfoService.getInfoByTime(startTime, endTime, userId);
		HealthLine healthLine = healthLineService.getSuggerLine(userId);
		
		sugger.setCode("211");
		sugger.setBloodSuggerInfo(bloodList);
		sugger.setHealthLine(healthLine);
		
		return  JSONObject.toJSONString(sugger);
	}
	
	/*
	 * 
	 *   医生查询用户特定时间段血糖数据
	 *  
	 * */
	@RequestMapping(value="/doctorQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorShow(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
	
		int user = jsonObject.getIntValue("userId");
		SuggerResponse sugger = new SuggerResponse();
		
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodSuggerInfo> bloodList = bloodSuggerInfoService.getInfoByTime(startTime, endTime, user);
		
		HealthLine healthLine = healthLineService.getSuggerLine(user);
		sugger.setCode("211");
		sugger.setHealthLine(healthLine);
		sugger.setBloodSuggerInfo(bloodList);
		
		return  JSONObject.toJSONString(sugger);
	}
	
	/*
	 * 
	 * 病人亲属查询用户特定时间段血糖数据
	 * */
	@RequestMapping(value="/friendQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String friendQuery(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
	
		int user = jsonObject.getIntValue("userId");
		SuggerResponse sugger = new SuggerResponse();
		
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodSuggerInfo> bloodList = bloodSuggerInfoService.getInfoByTime(startTime, endTime, user);
	
		sugger.setCode("211");
		sugger.setBloodSuggerInfo(bloodList);
		
		return  JSONObject.toJSONString(sugger);
	}
	
	
	/*
	 *  查询所有用户血糖信息
	 *  
	 * */
	@RequestMapping(value="/showAll",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBloodSuggerAll(HttpServletRequest request){
		Query query = Query.query(Criteria.where("userId").exists(true));
	
		
		
		List<BloodSuggerInfo> list =bloodSuggerInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	
	/*
	 * 
	 *  查询最近一段时间用户的血糖信息(单位为天，周，月)
	 * 
	 * */
	@RequestMapping(value="/latestDay",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String lates(HttpServletRequest request){
	
		SuggerResponse response = new SuggerResponse();
		
		List<BloodSuggerInfo> bloodList = null;
		int userId = (int)request.getAttribute("userId");
		HealthTarget healthTarget=null;
		healthTarget = healthTargetService.getHealthTarget(userId);
			bloodList = bloodSuggerInfoService.getlatestRecord(userId);	
			response.setCode("211");
			response.setHealthTarget(healthTarget);
			response.setBloodSuggerInfo(bloodList);

		return  JSONObject.toJSONString(response);
	}

	
	/*
	 *  上传用户血糖数据
	 * 
	 * */
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  upload(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		
		HealthInfoResponse response = new HealthInfoResponse();
		int userId =(int) request.getAttribute("userId");
		
		long date = jsonObject.getLongValue("measureTime");
	   
		double bsValue = jsonObject.getDoubleValue("bsValue");
		int measureType = jsonObject.getIntValue("measureType");

		BloodSuggerInfo sugger = new BloodSuggerInfo();
		
		sugger.setUserId(userId);
		sugger.setBsValue(bsValue);
		sugger.setMeasureTime(date);	
		sugger.setMeasureType(measureType);
		
		//保存数据
		bloodSuggerInfoService.addInfo(sugger, userId);
		response.setCode("0");//-1
		response.setMessage("血糖上传成功");
		
	
		return  JSON.toJSONString(response);
		
	}
}
