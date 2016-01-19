package com.hengyun.domain.hospital;

import java.io.Serializable;

//医生信息
public class Docter implements Serializable{

	private String workNum;
	private String name;
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
