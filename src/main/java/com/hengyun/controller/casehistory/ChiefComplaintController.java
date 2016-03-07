package com.hengyun.controller.casehistory;

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
import com.hengyun.domain.common.ResponseCode;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午3:59:21
* 病人主诉控制器
*/
@Controller
@RequestMapping("chiefComplaint")
public class ChiefComplaintController {

private static final Logger log = LoggerFactory.getLogger(ChiefComplaintController.class);
	
	
	/*
	 * 
	 *  添加病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addComplaint(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
	
	
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加病人主诉信息成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 *  查询病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryComplaint(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询病人主诉信息成功");
		return JSON.toJSONString(response);
	}
	

	/*
	 * 
	 *  显示所有病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showComplaint(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询所有病人主诉信息成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 
	 *  修改病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateComplaint(@RequestParam String data,HttpServletRequest request){
	JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("更新病人主诉信息成功");
		return JSON.toJSONString(response);
	}
	

	
	/*
	 * 
	 *  设置病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/set",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setComplaint(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);

		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("设置病人主诉信息成功");
		return JSON.toJSONString(response);
	}

	/*
	 * 
	 *  删除病人主诉信息
	 * 
	 * */
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteComplaint(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("删除病人主诉成功");
		return JSON.toJSONString(response);
	}

}
