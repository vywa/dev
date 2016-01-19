package com.hengyun.domain.friendcircle;

import java.io.Serializable;

/*
 *  朋友信息
 * 
 * */
public class Friend implements Serializable{

	private int 		friendId;					//朋友ID
	private String friendName;				//朋友名称
	
	private String loginStatus;							//登陆状态
	
	private String relation;							//关系状态,病人，好友
//	private List<Privilege> privilegeList;			
	//对朋友权限列表
	private String privilege;							//权限列表

	
	
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
	
}
