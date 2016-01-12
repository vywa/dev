package com.hengyun.domain.information;

import java.io.Serializable;

/*
 *  图片
 * */
public class Icon implements Serializable{

	private int id;									//图片id
	private String iconName;				//图片名称
	private int userId; 							//图片用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
