package com.hengyun.controller.patient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.domain.patient.HealthLine;
import com.hengyun.domain.patient.HealthLineResponse;
import com.hengyun.service.patient.HealthLineService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 下午2:11:16
* 健康评估参考线控制器
*/
@Controller
@RequestMapping("healthLine")
public class HealthLineController {

	@Resource
	private HealthLineService healthLineService;
	/*
	 * 
	 *  获取血压参考线
	 * */
	@RequestMapping(value="/pressureLine",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  pressureLine(HttpServletRequest request){
		
		int userId = (int)request.getAttribute("userId");
		
		HealthLineResponse response = new HealthLineResponse();
		HealthLine healthLine =healthLineService.getPressureLine(userId);
		response.setHealthLine(healthLine);
		response.setCode("206");
		response.setMessage("查询血压参数线成功");

		return JSON.toJSONString(response);
		
	}
	
	/*
	 * 
	 *  获取血糖参考线
	 * */
	@RequestMapping(value="/sugarLine",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  sugarLine(HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
	
		HealthLineResponse response = new HealthLineResponse();
		HealthLine healthLine =healthLineService.getPressureLine(userId);
		response.setHealthLine(healthLine);
		response.setCode("206");
		response.setMessage("查询血糖参数线成功");

		return JSON.toJSONString(response);
		
		
	}
}
