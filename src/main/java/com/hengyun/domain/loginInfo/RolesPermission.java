package com.hengyun.domain.loginInfo;

import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月22日 上午10:40:44
* 角色权限表
*/

public class RolesPermission {

	private int permissionId;									//权限id
	
	private String permissionName;					//权限名称
	
	private String description;									//权限描述

	

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
