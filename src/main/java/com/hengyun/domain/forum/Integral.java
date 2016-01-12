package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  积分管理
 * 
 * 
 * */
public class Integral implements Serializable{

	private  String operation;						//积分操作方式
	private int 	objectId;								//操作目标对象ID
	private String 	objectName;				//操作目标名称
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
}
