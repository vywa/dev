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

	private int userId;															//用户id
	
	private String roleName;												//角色名称
	//private List<Roles> roles;												角色列表

	private List<Resources> resourceList;						//资源列表
	
	private Date lastModified;											//最近更改时间

	
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Resources> getResourceList() {
		return resourceList;
	}
	
	public void setResourceList(List<Resources> resourceList) {
		this.resourceList = resourceList;
	}
	
	public Date getLastModified() {
		return lastModified;
	}
	
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
