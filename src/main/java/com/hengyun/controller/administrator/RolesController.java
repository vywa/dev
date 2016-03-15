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
	
	/*
	 *  添加角色
	 * */
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
	
	/*
	 *  查询所有角色
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showRoles(@RequestParam String data){
		List<Roles> rolesList = rolesService.queryAll();
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setRolesList(rolesList);
		
		return JSON.toJSONString(responseCode);
	}
	
	/*
	 *  删除角色
	 * */
	@RequestMapping(value="/deleteRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRole(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Roles role = JSON.toJavaObject(jsonObject, Roles.class);
		rolesService.deleteRole(role);
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage("删除成功");
		return JSON.toJSONString(responseCode);
	}
	
	/*
	 *  为角色添加资源
	 * */
	@RequestMapping(value="/addResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addResource(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Roles role = JSON.toJavaObject(jsonObject, Roles.class);
		rolesService.addResource(role, role.getResourceList().get(0));
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage("添加资源成功");
		return JSON.toJSONString(responseCode);
	}
	
	/*
	 *  某个角色删除资源
	 * */
	@RequestMapping(value="/deleteResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteResource(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Roles role = JSON.toJavaObject(jsonObject, Roles.class);
		rolesService.deleteResource(role, role.getResourceList().get(0));
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage("删除资源成功");
		return JSON.toJSONString(responseCode);
	}
	/*
	 *  查询角色所有的资源
	 * */
	@RequestMapping(value="/queryResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryResource(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		Roles role = JSON.toJavaObject(jsonObject, Roles.class);
		List<Resources> rlist = rolesService.queryResource(role);
		RolesResult responseCode = new RolesResult();
		responseCode.setCode("206");
		responseCode.setMessage(JSON.toJSONString(rlist));
		
		return JSON.toJSONString(responseCode);
	}
}
