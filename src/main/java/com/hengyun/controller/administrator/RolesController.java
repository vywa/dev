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
import com.hengyun.domain.administrator.Roles;
import com.hengyun.domain.administrator.RolesResult;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.administrator.RolesService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午4:44:58
* 角色控制器
*/

@Controller
@RequestMapping("roles")
public class RolesController {

	private static final Logger log = LoggerFactory.getLogger(RolesController.class);
	
	@Resource
	private RolesService rolesService;
	
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRoles(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Roles role = JSON.toJavaObject(jsonObject, Roles.class);
		rolesService.addRoles(role);
		ResponseCode responseCode = new ResponseCode();
		responseCode.setCode("206");
		responseCode.setMessage("添加成功");
		return JSON.toJSONString(responseCode);
	}
	
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showRoles(){
		List<Roles> rolesList = rolesService.queryAll();
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setRolesList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
}
