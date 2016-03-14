package com.hengyun.controller.administrator;

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
import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.Roles;
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
	
	/*
	 *  用户对某个资源是否有权限操作
	 * */
	@RequestMapping(value="/hasPermission",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String hasPermission(HttpServletRequest request){
		String permissionName= request.getParameter("name");
		String resourceName = request.getParameter("resourceName");
		String roleName = request.getParameter("roleName");
		String userIdStr = request.getParameter("userId");
		Permission permission = new Permission();
		permission.setName(permissionName);
		Resources resource = new Resources();
		resource.setResourceName(resourceName);
		Roles role = new Roles();
		role.setRoleName(roleName);
		int userId = Integer.valueOf(userIdStr);
		
		ResponseCode responseCode = new ResponseCode();
		boolean flag= userRoleService.hasPermission(permission, resource, role, userId);
		if(flag){
			responseCode.setCode("206");
			responseCode.setMessage("has permission");
		} else {
			responseCode.setCode("101");
			responseCode.setMessage("not have permission");
		}
		
		return JSON.toJSONString(responseCode);
	}
	
	
	//hasResourceForRole
	@RequestMapping(value="/hasResourceForRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String hasResourceForRole(HttpServletRequest request){
		
		String resourceName = request.getParameter("resourceName");
		String roleName = request.getParameter("roleName");
		String userIdStr = request.getParameter("userId");
		
		Roles role = new Roles();
		role.setRoleName(roleName);
		Resources resource = new Resources();
		resource.setResourceName(resourceName);
		int userId =Integer.valueOf(userIdStr);
		ResponseCode responseCode = new ResponseCode();
		boolean flag  = userRoleService.hasResourceForRole(resource, role, userId);
		if(flag){
			responseCode.setCode("206");
			responseCode.setMessage("has resource");
		} else {
			responseCode.setCode("101");
			responseCode.setMessage("not have resource");
		}
		
		return JSON.toJSONString(responseCode);
	}
	
	//hasResource
	@RequestMapping(value="/hasResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String hasResource(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	//hasRole
	@RequestMapping(value="/hasRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String hasRole(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	//setPermission
	@RequestMapping(value="/setPermission",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setPermission(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	//deletePermission
	@RequestMapping(value="/deletePermission",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deletePermission(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	
	//addPermission
	@RequestMapping(value="/addPermission",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPermission(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	//deleteResource
	@RequestMapping(value="/deleteResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteResource(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	//addResource
	@RequestMapping(value="/addResource",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addResource(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	
	//delete
	@RequestMapping(value="/deleteRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRole(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	
	
	//addRole
	@RequestMapping(value="/addRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRole(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
	//deleteUserRole
	@RequestMapping(value="/deleteUserRole",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteUserRole(){
		List<UserRole> rolesList = userRoleService.queryAll();
		UserRoleResult responseCode = new UserRoleResult();
		responseCode.setCode("206");
		responseCode.setMessage("查询成功");
		responseCode.setUserRoleList(rolesList);
		return JSON.toJSONString(responseCode);
	}
	
}
