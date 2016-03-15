package com.hengyun.controller.administrator;

import java.util.ArrayList;
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
import com.hengyun.domain.administrator.UserRole;
import com.hengyun.domain.administrator.UserRoleResult;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.administrator.UserRoleService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午6:18:48
* 角色用户管理控制器
*/
@Controller
@RequestMapping("userRole")
public class UserRoleController {

	private static final Logger log = LoggerFactory.getLogger(UserRoleController.class);
	
	@Resource
	private UserRoleService userRoleService;
	
	/*
	 *  添加用户
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRoles(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		UserRole userRole = JSON.toJavaObject(jsonObject, UserRole.class);
		userRoleService.addUserRole(userRole);
		ResponseCode responseCode = new ResponseCode();
		responseCode.setCode("206");
		responseCode.setMessage("添加成功");
		return JSON.toJSONString(responseCode);
	}
	
	/*
	 *  查询用户的资源
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
		UserRole userRole = userRoleService.query(userId);
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		userRoleList.add(userRole);
		responseCode.setUserRoleList(userRoleList);
		return JSON.toJSONString(responseCode);
	}
	
	
	
	/*
	 *  给用户添加资源
	 * */
	@RequestMapping(value="/addResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addResource(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		UserRole userRole = JSON.toJavaObject(jsonObject, UserRole.class);
		userRoleService.addResource(userRole.getResourceList().get(0), userRole.getUserId());
	
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("添加资源成功");
		return JSON.toJSONString(responseCode);
	}
	
	/*
	 *  给用户删除资源
	 * */
	@RequestMapping(value="/deleteResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteResource(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		UserRole userRole = JSON.toJavaObject(jsonObject, UserRole.class);
		userRoleService.deleteResource(userRole.getResourceList().get(0), userRole.getUserId());
	
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("删除资源成功");
		return JSON.toJSONString(responseCode);
	}

}
