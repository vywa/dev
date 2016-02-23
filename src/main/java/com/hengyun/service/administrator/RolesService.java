package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Roles;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:54:03
* 角色业务类
*/
public interface RolesService extends BaseService<Roles,Integer>{

	//添加角色
	public void addRoles(Roles role);
	
	//查询角色
	public List<Roles> queryAll();
}
