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
import com.hengyun.domain.casehistory.SportInfo;
import com.hengyun.domain.casehistory.response.SportInfoResponse;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.SportInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:41:18
* 类说明
*/
@Controller
@RequestMapping("sport")
public class SportInfoController {

	@Resource
	private SportInfoService sportInfoService;
	
	/*
	 *  添加运动情况
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addSport(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		SportInfo sportInfo = JSON.toJavaObject(jsonObject, SportInfo.class);
		int userId = (int)request.getAttribute("userId");
		sportInfo.setUserId(userId);
		sportInfoService.addSport(sportInfo);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加运动信息成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  查询运动情况
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String querySport(HttpServletRequest request){
		
	
		int userId =(int)request.getAttribute("userId");
		List<SportInfo> list = sportInfoService.getSportList(userId);
		SportInfoResponse response = new SportInfoResponse();
		response.setSportList(list);
		response.setCode("206");
		response.setMessage("查询健康习惯成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 *  删除运动情况
	 * */
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateHabit(@RequestParam String data,HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		sportInfoService.delete(userId, id);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("删除运动成功");
		return JSON.toJSONString(response);
	}
	
}
