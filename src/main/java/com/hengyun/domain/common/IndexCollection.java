package com.hengyun.domain.common;

import java.io.Serializable;

/*
 *  数据库中自增索引
 * */
public class IndexCollection implements Serializable{

	private int docterID;									//初始值100000000
	private int patientID;								//初始值200000000
	
	
	public int getDocterID() {
		return docterID;
	}
	public void setDocterID(int docterID) {
		this.docterID = docterID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	
	
}
