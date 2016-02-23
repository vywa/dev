package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午8:27:25
* 用户角色表
*/


public class UserRole implements Serializable{

	private int userId;								//用户id
	private List<Roles> roles;					//角色列表
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
	
}
