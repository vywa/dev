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

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午4:23:45
* 现病史控制器
*/

@Controller
@RequestMapping("current")
public class CurrentDiseaseHistoryController {
	
	private static final Logger log = LoggerFactory.getLogger(CurrentDiseaseHistoryController.class);
	
	
	/*
	 * 
	 *  添加病人现病史
	 * 
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addCurrent(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
	
	
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加病人现病史成功");
		return JSON.toJSONString(response);
	}
	/*
	 * 
	 *  查询病人现病史
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryPatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询病人现病史成功");
		return JSON.toJSONString(response);
	}
	

	/*
	 * 
	 *  显示所有病人现病史
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showPatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("显示所有病人现病史成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 
	 *  修改病人现病史信息
	 * 
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePatient(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("修改病人现病史信息成功");
		return JSON.toJSONString(response);
	}
	

}
	



