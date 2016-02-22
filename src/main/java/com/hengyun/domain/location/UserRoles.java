package com.hengyun.domain.location;

import java.util.List;

import com.hengyun.domain.loginInfo.RolesPermission;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月22日 上午10:42:17
* 用户角色表
*/
public class UserRoles {

	
	
	private int roleId;										//角色id
	
	private String roleName;							//角色名称
	
	private String description;						//角色描述
	

	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
