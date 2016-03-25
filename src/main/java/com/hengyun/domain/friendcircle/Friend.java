package com.hengyun.domain.friendcircle;

import java.io.Serializable;

/*
 *  朋友信息
 * 
 * */
public class Friend implements Serializable{

	private int 		friendId;					//朋友ID

	private String friendName;				//朋友名称
	
	private String loginStatus;				//登陆状态
	
	private String relation;						//关系医生，病人，好友,家人
	
	private String privilege;							//权限，聊天，看动态

	


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
