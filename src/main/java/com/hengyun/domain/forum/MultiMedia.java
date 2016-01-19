package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  多媒体类
 * */
public class MultiMedia implements Serializable{

	private int id;									//图片id
	private String Name;				//图片名称
	private int userId; 							//图片用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
