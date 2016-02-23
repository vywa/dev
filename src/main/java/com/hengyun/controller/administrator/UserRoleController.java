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
	
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showRoles(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
}
