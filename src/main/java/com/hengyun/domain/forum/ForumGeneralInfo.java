package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  用户论坛基本信息
 * 
 * */
public class ForumGeneralInfo implements Serializable{

	private String userId;													//用户ID
	private String nickname;									//论坛昵称
	private String Icon;											//论坛图片
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIcon() {
		return Icon;
	}
	public void setIcon(String icon) {
		Icon = icon;
	}
	
	

	
}
