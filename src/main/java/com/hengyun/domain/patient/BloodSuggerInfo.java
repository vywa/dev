package com.hengyun.domain.patient;

import java.io.Serializable;

/*
 * 血糖信息
 * */

public class BloodSuggerInfo implements Serializable{

	
	private int userId;								//病人ID

	private long measureTime;			//测量时间
	private double bsValue;			//血糖值
	private int measureType;				//测量类型
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getMeasureTime() {
		return measureTime;
	}
	public void setMeasureTime(long measureTime) {
		this.measureTime = measureTime;
	}
	public double getBsValue() {
		return bsValue;
	}
	public void setBsValue(double bsValue) {
		this.bsValue = bsValue;
	}
	public int getMeasureType() {
		return measureType;
	}
	public void setMeasureType(int measureType) {
		this.measureType = measureType;
	}
	
	
	
}
