package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Permission;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午11:18:17
* 权限操作接口
*/
public interface PermissionService extends BaseService<Permission,Integer>{

	//添加权限
	public void addPermission(Permission permission);
	
	//删除权限
	public void deletePermission(Permission permission);
	
	//更改权限
	public void updatePermission(Permission permission);
	
	//查询权限
	public Permission queryPermission(Permission permission); 
	
	//查看所有权限
	public List<Permission> queryAll();
}
