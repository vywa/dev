package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.Date;

/*
 *  
 *  血压信息
 *  
 * */

public class BloodPressureInfo implements Serializable{

	private int userId;										//病人id
	private int id;												//测量id
	private long measureTime;					//测量时间
	private int highBP;										//高压数据
	private int lowBP;										//d低压数据
	private int heartRate;								//测量心率
	private int arrhythmia;							//心率不齐
	private Date recordTime;							//上传时间
	

	

	public int getArrhythmia() {
		return arrhythmia;
	}
	public void setArrhythmia(int arrhythmia) {
		this.arrhythmia = arrhythmia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("病人").append(userId).append("的高压为: ").append(highBP).
		append(" ,低压为: ").append(lowBP).append(",心率为: ").append(heartRate).append(",测量时间为").append(measureTime);
		return sb.toString();
	}
	
	
	
}
