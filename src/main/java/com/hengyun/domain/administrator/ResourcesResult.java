package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午4:12:11
* 资源返回结果类
*/
public class ResourcesResult extends ResponseCode implements Serializable{

	private List<Resources> resourcesList;

	public List<Resources> getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(List<Resources> resourcesList) {
		this.resourcesList = resourcesList;
	}
	
	
}
