package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:54:40
* 资源业务层
*/
public interface ResourcesService extends BaseService<Resources,Integer>{

	//添加资源
	public void addResource(Resources resource);
	
	//查看资源
	public List<Resources> queryAllResource();
	
	
	
	//给资源添加权限
	public void addPermission(Resources resource ,Permission permission);
	
	//给资源删除权限
	public void deletePermission(Resources resource,Permission permission);
	
	//设置资源对应的权限
	public void setPermission(Resources resource,Permission permission);
	
	//设置默认权限列表
	public void initPermission(Resources resource);
	
	//获取默认权限列表
	public List<Permission> getPermission(Resources resource);
}
