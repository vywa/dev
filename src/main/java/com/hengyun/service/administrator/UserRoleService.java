package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
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
	public void deleteUserRole(Roles role ,int userId);
	
	
	//查询角色列表
	public List<UserRole> queryAll();
	
	//查询用户的角色列表
	public List<Roles> RolebyId(int userId);
	
	
	
	//给用户添加角色
	public boolean addRole(Roles role ,int userId);
	
	//给用户删除角色
	public boolean delete(Roles role,int userId);
	
	//给用户j角色添加资源
	public boolean addResource(Resources resource,Roles role,int userId);
	
	//给用户角色删除资源
	public void deleteResource(Resources resource,Roles role,int userId);
	
	//给用户资源添加权限
	public void addPermission(Permission permission ,Resources resource,Roles role,int userId);
	
	//给用户资源删除权限
	public void deletePermission(Permission permission,Resources resource,Roles role,int userId);
	
	//给用户资源设置权限
	public void setPermission(Permission permission,Resources resource,Roles role,int userId,boolean available);
	
	//查询用户是否拥有该角色权限
	public boolean hasRole(Roles role,int userId);
	
	//查询用户是否拥有该资源
	public boolean hasResource(Resources resource,int userId);
	
	//查询某角色是否拥有该资源
	public boolean hasResourceForRole(Resources resource,Roles role,int userId);
	
	//查询是否拥有某个资源某种权限
	public boolean hasPermission(Permission permission,Resources resource,Roles role,int userId);
	
	
	
}
