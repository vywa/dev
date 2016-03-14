package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午8:48:00
* 资源描述
*/
public class Resources implements Serializable{

	private int resourceId;												//资源id
	private String resourceName;								//资源名称
	private String description;										//资源描述
	private String status;													//资源状态
	
//	private List<Permission> permissionList;			资源对应的权限列表
	
	private Date createTime;											//创建日期
	private Date lastModifyTime;									//最近修改时间
	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
