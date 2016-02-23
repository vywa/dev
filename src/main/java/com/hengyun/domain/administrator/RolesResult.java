package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午5:06:10
* 角色结果返回值
*/
public class RolesResult extends ResponseCode implements Serializable{

	private List<Roles> rolesList;								//角色列表

	public List<Roles> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}
	
	
}
