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
import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.PermissionResult;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.administrator.PermissionService;

/*
 *  权限操作
 * */
@Controller
@RequestMapping("permission")
public class PermissionController {
	
	private static final Logger log = LoggerFactory.getLogger(PermissionController.class);
	
	@Resource
	private PermissionService permissionService;
	
	
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPermission(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Permission permission = JSON.toJavaObject(jsonObject, Permission.class);
		permissionService.addPermission(permission);
		ResponseCode responseCode = new ResponseCode();
		responseCode.setCode("206");
		responseCode.setMessage("添加成功");
		return JSON.toJSONString(responseCode);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updatePermission(){
		
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deletePermission(){
		
		return null;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryPermission(){
		return null;
	}
	
	
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showPermission(){
		List<Permission> permissionList = permissionService.queryAll();
		PermissionResult responseCode = new PermissionResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setPermissionList(permissionList);
		return JSON.toJSONString(responseCode);
	}
	
	
}
