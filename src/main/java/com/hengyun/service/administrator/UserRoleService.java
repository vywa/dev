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

	//添加用户资源
	public void addUserRole(UserRole userRole);

	//用户添加资源
	public void addResource(Resources resources ,int userId);
	
	//用户删除资源
	public void deleteResource(Resources resources , int userId);
	
	//用户是否拥有该资源
	public boolean hasResource(Resources resource,int userId);
	
	
	

	
}
