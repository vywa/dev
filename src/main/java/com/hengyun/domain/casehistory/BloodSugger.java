package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午7:55:51
* 血糖信息类
*/
public class BloodSugger implements Serializable{

	private int diseaseHistory;															//病程几年
	private float highBloodSugger;												//最高血糖
	private float commonEmptyStamatch;								//平时空腹血糖
	private float commonAfterEat;												//平时餐后血糖
	
	private String cureEffact;																//目前用药疗效
	private String adhereDisease;													//糖尿病并发症
	public int getDiseaseHistory() {
		return diseaseHistory;
	}
	public void setDiseaseHistory(int diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	public float getHighBloodSugger() {
		return highBloodSugger;
	}
	public void setHighBloodSugger(float highBloodSugger) {
		this.highBloodSugger = highBloodSugger;
	}
	public float getCommonEmptyStamatch() {
		return commonEmptyStamatch;
	}
	public void setCommonEmptyStamatch(float commonEmptyStamatch) {
		this.commonEmptyStamatch = commonEmptyStamatch;
	}
	public float getCommonAfterEat() {
		return commonAfterEat;
	}
	public void setCommonAfterEat(float commonAfterEat) {
		this.commonAfterEat = commonAfterEat;
	}
	public String getCureEffact() {
		return cureEffact;
	}
	public void setCureEffact(String cureEffact) {
		this.cureEffact = cureEffact;
	}
	public String getAdhereDisease() {
		return adhereDisease;
	}
	public void setAdhereDisease(String adhereDisease) {
		this.adhereDisease = adhereDisease;
	}
	
	
}
