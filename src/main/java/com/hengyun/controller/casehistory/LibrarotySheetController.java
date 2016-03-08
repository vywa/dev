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
* @version 创建时间：2016年3月8日 下午3:14:59
* 化验单控制器
*/

@Controller
@RequestMapping("libSheet")
public class LibrarotySheetController {
	
	private static final Logger log = LoggerFactory.getLogger(LibrarotySheetController.class);
	
	
	/*
	 * 
	 *  添加化验单信息
	 * 
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addlibSheet(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
	
	
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("添加化验单信息成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 *  查询化验单信息
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String querylibSheet(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("查询化验单信息成功");
		return JSON.toJSONString(response);
	}
	

	/*
	 * 
	 *  显示所有化验单信息
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showlibSheet(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("显示所有化验单信息成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 
	 *  修改化验单信息
	 * 
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatelibSheet(@RequestParam String data,HttpServletRequest request){
	JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("修改化验单信息成功");
		return JSON.toJSONString(response);
	}
	

	
	/*
	 * 
	 *  设置化验单信息
	 * 
	 * */
	@RequestMapping(value="/set",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setlibSheet(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);

		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("设置化验单信息成功");
		return JSON.toJSONString(response);
	}

	/*
	 * 
	 *  删除化验单信息
	 * 
	 * */
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deletelibSheet(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("删除化验单信息成功");
		return JSON.toJSONString(response);
	}
}
