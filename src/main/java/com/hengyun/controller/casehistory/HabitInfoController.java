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
import com.hengyun.controller.BaseController;
import com.hengyun.domain.casehistory.HabitInfo;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.patient.HabitInfoResponse;
import com.hengyun.service.patient.HabitInfoService;
import com.hengyun.util.json.JSONUtil;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午4:05:31
* 健康习惯控制器
*/
@Controller
@RequestMapping("habit")
public class HabitInfoController extends BaseController{

	private static final Logger log = LoggerFactory.getLogger(HabitInfoController.class);
	
	@Resource 
	private HabitInfoService habitInfoService;
	
	/*
	 *  添加健康习惯
	 * */
	@RequestMapping("/add")
	@ResponseBody
	public String addHabit(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		HabitInfo habitInfo = JSONUtil.toJavaObject(jsonObject, HabitInfo.class);
		habitInfoService.storeHabit(habitInfo);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加健康习惯成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  添加健康习惯
	 * */
	@RequestMapping("/query")
	@ResponseBody
	public String queryHabit(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
		HabitInfo habitInfo = habitInfoService.query(userId);
		HabitInfoResponse response = new HabitInfoResponse();
		response.setHabitInfo(habitInfo);
		response.setCode("206");
		response.setMessage("查询健康习惯成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  更新健康习惯
	 * */
	@RequestMapping("/update")
	@ResponseBody
	public String updateHabit(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		HabitInfo habitInfo = JSONUtil.toJavaObject(jsonObject, HabitInfo.class);
		habitInfoService.update(habitInfo);
		
		HabitInfoResponse response = new HabitInfoResponse();
		response.setCode("206");
		response.setMessage("更新健康习惯成功");
		return JSON.toJSONString(response);
	}
	
}
