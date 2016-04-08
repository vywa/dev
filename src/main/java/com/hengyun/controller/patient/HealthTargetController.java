package com.hengyun.controller.patient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.domain.patient.HealthTarget;
import com.hengyun.domain.patient.HealthTargetResponse;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.patient.HealthTargetService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午5:06:27
* 设置健康目标控制器
*/
@Controller
@RequestMapping("healthTarget")
public class HealthTargetController {

	private static final Logger log = LoggerFactory.getLogger(HealthTarget.class);
	
	@Resource
	private HealthTargetService healthTargetService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	/*
	 * 
	 *  设置控压数据
	 * */
	@RequestMapping(value="/setBloodPressure",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  setBloodPressure(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject = JSON.parseObject(data);
		
		HealthTargetResponse response = new HealthTargetResponse();
	
		int userId = (int)request.getAttribute("userId");
		HealthTarget blood = JSON.toJavaObject(jsonObject, HealthTarget.class);
		blood.setPatientId(userId);
		//保存数据
		healthTargetService.setBloodPressure(blood);
		response.setCode("206");
		response.setMessage("设置控压成功");
	
		
		return JSON.toJSONString(response);
		
	}
	
	/*
	 * 
	 *  设置控糖数据
	 * */
	@RequestMapping(value="/setBloodSugger",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  setBloodSugger(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = (int)request.getAttribute("userId");
		
		HealthTargetResponse response = new HealthTargetResponse();
		HealthTarget healthTarget = JSON.toJavaObject(jsonObject, HealthTarget.class);
		healthTarget.setPatientId(userId);
		
		//保存数据
		  healthTargetService.setBloodSugger(healthTarget);
		response.setCode("206");
		response.setMessage("设置控压成功");
	
	
		return JSON.toJSONString(response);
		
		
	}
	
	/*
	 * 
	 *  查询控压数据
	 * */
	@RequestMapping(value="/getBloodPressure",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  getBloodPressure(HttpServletRequest request){
		
	
		int userId = (int)request.getAttribute("userId");
		HealthTargetResponse response = new HealthTargetResponse();
		
		
		//查询降压目标
		response = healthTargetService.getBloodPressure(userId);
		response.setCode("206");
		response.setMessage("查询降压目标成功");
	
		
		return JSON.toJSONString(response);
		
	}
	
	/*
	 * 
	 *  获取控糖数据
	 * */
	@RequestMapping(value="/getBloodSugger",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  getBloodSugger(HttpServletRequest request){
		
		
		HealthTargetResponse response = new HealthTargetResponse();
		int userId = (int)request.getAttribute("userId");
	
		//保存数据
		response = healthTargetService.getBloodSugger(userId);
		response.setCode("206");
		response.setMessage("查询降糖目标成功");
		
	
		return JSON.toJSONString(response);
		
	}
	
}
