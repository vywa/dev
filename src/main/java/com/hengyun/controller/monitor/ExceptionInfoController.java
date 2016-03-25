package com.hengyun.controller.monitor;

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
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.monitor.ExceptionInfo;
import com.hengyun.domain.monitor.ExceptionInfoResponse;
import com.hengyun.service.monitor.ExceptionInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午4:58:21
* 异常信息控制类
*/
@Controller
@RequestMapping("exception")
public class ExceptionInfoController {

	private static final Logger log = LoggerFactory.getLogger(ExceptionInfoController.class);
	
	@Resource
	private ExceptionInfoService exceptionInfoService;
	
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(HttpServletRequest request,@RequestParam String data){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		ExceptionInfo info = JSON.toJavaObject(jsonObject, ExceptionInfo.class);
		exceptionInfoService.add(info);
		response.setCode("206");
		response.setMessage("上传成功");
		return JSON.toJSONString(response);
	}
	
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request,@RequestParam String data){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		ExceptionInfo info = JSON.toJavaObject(jsonObject, ExceptionInfo.class);
		exceptionInfoService.del(info);
		response.setCode("206");
		response.setMessage("删除成功");
		return JSON.toJSONString(response);
	}
	
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request,@RequestParam String data){
		ExceptionInfoResponse response = new ExceptionInfoResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		ExceptionInfo info = JSON.toJavaObject(jsonObject, ExceptionInfo.class);
		List<ExceptionInfo> list =  exceptionInfoService.query(info.getIp());
		
		response.setCode("206");
		response.setMessage("删除成功");
		response.setExceptionInfoList(list);
		return JSON.toJSONString(response);
	}
}
