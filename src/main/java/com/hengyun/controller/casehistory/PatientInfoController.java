package com.hengyun.controller.casehistory;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;


/*
 * @author bob E-mail:panbaoan@thealth.cn
 *  病人基本信息控制器
 * */

@Controller
@RequestMapping("patienInfo")
public class PatientInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(PatientInfoController.class);
	
	
	/*
	 * 
	 *  添加病人基本信息
	 * 
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPatient(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
	
	
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加病人基本资料成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 *  查询病人信息
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryPatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询病人基本资料成功");
		return JSON.toJSONString(response);
	}
	

	/*
	 * 
	 *  显示所有病人信息
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showPatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询所有病人基本资料成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 
	 *  修改病人基本信息
	 * 
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePatient(@RequestParam String data,HttpServletRequest request){
	JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("更新病人基本资料成功");
		return JSON.toJSONString(response);
	}
	

	
	/*
	 * 
	 *  设置病人基本信息
	 * 
	 * */
	@RequestMapping(value="/set",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setPatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);

		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("设置病人基本资料成功");
		return JSON.toJSONString(response);
	}

	/*
	 * 
	 *  删除病人基本信息
	 * 
	 * */
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deletePatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("删除病人基本资料成功");
		return JSON.toJSONString(response);
	}

	
}
