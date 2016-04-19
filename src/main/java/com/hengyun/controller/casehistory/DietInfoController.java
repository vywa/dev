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
import com.hengyun.domain.casehistory.DietInfo;
import com.hengyun.domain.casehistory.response.DietInfoResponse;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.DietInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:41:31
* 类说明
*/
@Controller
@RequestMapping("diet")
public class DietInfoController {

	@Resource
	private DietInfoService dietInfoService;
	
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addDiet(@RequestParam String data,HttpServletRequest request){
		
		int userId = (int)request.getAttribute("userId");
		
		JSONObject jsonObject =JSON.parseObject(data);
		DietInfo dietInfo = JSON.toJavaObject(jsonObject, DietInfo.class);
		dietInfo.setUserId(userId);
		dietInfoService.addDiet(dietInfo);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加饮食成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  查询饮食习惯
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
	
		List<DietInfo> list = dietInfoService.getDietList(userId);
		DietInfoResponse response = new DietInfoResponse();
		response.setDietInfoList(list);
		response.setCode("206");
		response.setMessage("查询饮食成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  医生查询病人饮食习惯
	 * */
	@RequestMapping(value="/dquery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dquery(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
	
		List<DietInfo> list = dietInfoService.getDietList(userId);
		DietInfoResponse response = new DietInfoResponse();
		response.setDietInfoList(list);
		response.setCode("206");
		response.setMessage("查询饮食成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  更新饮食习惯
	 * */
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String delete(@RequestParam String data,HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		dietInfoService.delete(userId, id);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("删除饮食成功");
		return JSON.toJSONString(response);
	}
	
}
