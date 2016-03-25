package com.hengyun.controller.forum;

import java.util.List;

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
import com.hengyun.domain.forum.SubjectAvailableList;
import com.hengyun.domain.forum.response.SubjectAvailableListResponse;
import com.hengyun.service.forum.SubjectAvailableListService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 上午11:49:19
* 朋友圈权限控制器
*/
@Controller
@RequestMapping("see")
public class SubjectAvailableListController {

	private static final Logger log = LoggerFactory.getLogger(SubjectAvailableListController.class);
	
	@Resource
	private SubjectAvailableListService subjectAvailableListService;
	
	/*
	 *  更新可见列表
	 * */
	@RequestMapping(value="/updateAvailable",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateAvailable(@RequestParam String data,HttpServletRequest request){
		SubjectAvailableListResponse response = new SubjectAvailableListResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		SubjectAvailableList list = JSON.toJavaObject(jsonObject, SubjectAvailableList.class);
		subjectAvailableListService.updateAvailable(list);
		
		response.setCode("206");
		response.setMessage("更新可见列表成功");
		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  更新关注列表
	 * */
	@RequestMapping(value="/updateSubscribe",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSubscribe(@RequestParam String data,HttpServletRequest request){
		SubjectAvailableListResponse response = new SubjectAvailableListResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		SubjectAvailableList list = JSON.toJavaObject(jsonObject, SubjectAvailableList.class);
		subjectAvailableListService.updateSubscribe(list);
		
		response.setCode("206");
		response.setMessage("更新关注列表成功");
		return JSON.toJSONString(response);
		
	}
	
	
	/*
	 * 查询可见列表
	 * */
	@RequestMapping(value="/queryAvailable",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryAvailable(@RequestParam String data,HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
		SubjectAvailableListResponse response = new SubjectAvailableListResponse();
	
		List<Integer> list = subjectAvailableListService.queryAvailable(userId);
		
		response.setCode("206");
		response.setMessage("更新关注列表成功");
		response.setAvailable(list);
		return JSON.toJSONString(response);
		
	}
	
	
	/*
	 * 查询关注列表
	 * */
	@RequestMapping(value="/querySubscribe",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String querySubscribe(@RequestParam String data,HttpServletRequest request){
		int userId = (int)request.getAttribute("userId");
		
		SubjectAvailableListResponse response = new SubjectAvailableListResponse();
	
		List<Integer> list = subjectAvailableListService.querySubscribe(userId);
		
		response.setCode("206");
		response.setMessage("查询关注列表成功");
		response.setSubscribe(list);
		return JSON.toJSONString(response);
		
	}
}
