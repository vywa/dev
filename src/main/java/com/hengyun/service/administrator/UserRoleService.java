package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Roles;
import com.hengyun.domain.administrator.UserRole;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:20:06
* 用户角色资源业务接口
*/
public interface UserRoleService extends BaseService<UserRole,Integer>{

	//添加角色
	public void addUserRole(UserRole userRole);
	
	
	//删除角色
	public void deleteUserRole(UserRole userRole,Roles role);
	
	
	//查询角色列表
	public List<UserRole> queryAll();
	
	
	//角色添加资源
	public void addResource(UserRole userRole);
	
	
	//角色删除资源
	public void deleteResource(UserRole userRole);
	
	
	//资源添加权限
	public void addPermission(UserRole userRole);
	
	
	//资源删除权限
	public void deletePermission(UserRole userRole);
		
	
	//查询用户是否对资源有访问权限
	public boolean hasPower(String resource,int userId);
	
}
