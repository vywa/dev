package com.hengyun.domain.friendcircle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月24日 下午3:12:22
* 家庭圈
*/
public class FamilyCircle implements Serializable{

	private int userId;		//用户id

	private List<Integer> idList = new ArrayList<Integer>();		//家庭成员圈子
	
	private List<String> privilegeList = new ArrayList<String>();		//授予权限列表

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public List<String> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<String> privilegeList) {
		this.privilegeList = privilegeList;
	}
	
	
}
