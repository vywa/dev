package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午2:04:31
* 随访信息
*/
public class Followup implements Serializable{

	private int id;										//随访记录id
	private int doctorId;							//医生id
	private int patientId;						//病人id
	
	private int highBP;								//高压数据
	private int lowBP;								//d低压数据
	private int heartRate;						//测量心率
	
	private double bsValue;					//血糖值
	private int remainTablet;					//剩余药
	private float doses;							//吃药片剂量
	private String nextFollow;				//下次随访时间
	
	
	
	private Date 			recordTime;				//记录时间



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
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



	public double getBsValue() {
		return bsValue;
	}



	public void setBsValue(double bsValue) {
		this.bsValue = bsValue;
	}



	public int getRemainTablet() {
		return remainTablet;
	}



	public void setRemainTablet(int remainTablet) {
		this.remainTablet = remainTablet;
	}


	public float getDoses() {
		return doses;
	}



	public void setDoses(float doses) {
		this.doses = doses;
	}



	public String getNextFollow() {
		return nextFollow;
	}



	public void setNextFollow(String nextFollow) {
		this.nextFollow = nextFollow;
	}



	public Date getRecordTime() {
		return recordTime;
	}



	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
