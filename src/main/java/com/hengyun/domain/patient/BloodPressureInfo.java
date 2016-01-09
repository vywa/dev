package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.Date;

/*
 *  
 *  血压信息
 * */

public class BloodPressureInfo implements Serializable{

	
	private int userId;								//病人id
	private long measureTime;					//测量时间
	private int highBP;								//高压数据
	private int lowBP;								//d低压数据
	private int heartRate;								//测量心率

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
	public int getHighBP() {
		return highBP;
	}
	public void setHighBP(int highBP) {
		this.highBP = highBP;
	}
	public int getLowBP() {
		return lowBP;
	}
	public void setLowBP(int lowBP) {
		this.lowBP = lowBP;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	

	
}
