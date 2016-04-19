package com.hengyun.controller.health;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.health.MedicalRecord;
import com.hengyun.domain.health.MedicalRecordResponse;
import com.hengyun.service.health.MedicalRecordService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 上午11:03:14
* 病历记录控制器
*/
@Controller
@RequestMapping("mrecord")
public class MedicalRecordController {

	@Resource
	private MedicalRecordService medicalRecordService;
	
	/*
	 *  添加病历情况
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRecord(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		MedicalRecord medicalRecord = JSON.toJavaObject(jsonObject, MedicalRecord.class);
		int userId = (int)request.getAttribute("userId");
		medicalRecord.setPatientId(userId);
		medicalRecordService.addRecord(medicalRecord);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加病历信息成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 *   医生查询病历情况
	 *  
	 * */
	@RequestMapping(value="/dquery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dqueryRecord(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");

		List<MedicalRecord> list = medicalRecordService.queryList(userId);
		MedicalRecordResponse response = new MedicalRecordResponse();
		response.setRecordList(list);
		response.setCode("206");
		response.setMessage("查询病历列表成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 *  病人查询病历情况
	 * */
	@RequestMapping(value="/pquery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryRecord(HttpServletRequest request){
		
		int userId =(int)request.getAttribute("userId");
		List<MedicalRecord> list = medicalRecordService.queryList(userId);
		MedicalRecordResponse response = new MedicalRecordResponse();
		response.setRecordList(list);
		response.setCode("206");
		response.setMessage("查询病历列表成功");
		return JSON.toJSONString(response);
	}
	
	
}
