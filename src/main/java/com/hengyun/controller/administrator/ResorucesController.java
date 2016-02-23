package com.hengyun.controller.administrator;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.ResourcesResult;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.administrator.ResourcesService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午4:07:39
* 资源管理控制类
*/
@Controller
@RequestMapping("resources")
public class ResorucesController {

	private static final Logger log = LoggerFactory.getLogger(PermissionController.class);
	
	@Resource
	private ResourcesService resourcesService;
	
	
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addResource(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Resources resource = JSON.toJavaObject(jsonObject, Resources.class);
		resourcesService.addResource(resource);
		ResponseCode responseCode = new ResponseCode();
		responseCode.setCode("206");
		responseCode.setMessage("添加成功");
		return JSON.toJSONString(responseCode);
	}
	
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showResource(){
		List<Resources> resourcesList = resourcesService.queryAllResource();
		ResourcesResult responseCode = new ResourcesResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setResourcesList(resourcesList);
		return JSON.toJSONString(responseCode);
	}
}
