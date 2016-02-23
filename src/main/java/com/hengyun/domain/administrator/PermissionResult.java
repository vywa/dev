package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午11:43:36
* 权限查询返回类
*/
public class PermissionResult extends ResponseCode implements Serializable{
	private List<Permission> permissionList;

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	

}
