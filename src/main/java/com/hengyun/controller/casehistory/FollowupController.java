package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.Followup;
import com.hengyun.domain.casehistory.response.FollowupResponse;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.FollowupService;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午3:12:45
* 随访记录控制器
*/
@Controller
@RequestMapping("followup")
public class FollowupController {

	@Resource
	private FollowupService followupService;
	
	/*
	 *  添加随访情况
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addFollowup(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		Followup followup = JSON.toJavaObject(jsonObject, Followup.class);
		int userId = (int)request.getAttribute("userId");
		followup.setDoctorId(userId);
		followupService.addFollow(followup);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加随访记录成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  添加随访情况
	 * */
	@RequestMapping(value="/and",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String add(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		
		Followup followup = JSON.toJavaObject(jsonObject, Followup.class);
		int userId = (int)request.getAttribute("userId");
		followup.setDoctorId(userId);
		followupService.addFollow(followup);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加随访记录成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *   查询随访情况
	 * */
	@RequestMapping(value="doctor/queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request,@RequestParam(required=false) String data){
		JSONObject jsonObject =JSON.parseObject(data);
		int patientId = jsonObject.getIntValue("patientId");
		List<Followup> followupList = followupService.queryPList(patientId);
		FollowupResponse response = new FollowupResponse();
		response.setFollowupList(followupList);
		response.setCode("206");
		response.setMessage("查询随访记录成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  查询随访情况
	 * */
	@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryList(HttpServletRequest request,@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		int patientId = jsonObject.getIntValue("patientId");
		List<Followup> followupList = followupService.queryPList(patientId);
		FollowupResponse response = new FollowupResponse();
		response.setFollowupList(followupList);
		response.setCode("206");
		response.setMessage("查询随访记录成功");
		return JSON.toJSONString(response);
	}
	
}
