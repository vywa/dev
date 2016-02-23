package com.hengyun.domain.administrator;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 下午6:24:46
* 用户角色返回结果类
*/
public class UserRoleResult extends ResponseCode implements Serializable{
	private List<UserRole> userRoleList ;

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
	
	
}
