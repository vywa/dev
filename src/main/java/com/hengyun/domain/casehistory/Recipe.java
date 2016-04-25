package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午11:34:33
* 处方类
*/
public class Recipe implements Serializable{

//	private int doctorAdviceId;									//医嘱id
	
	private int recipeId;													//处方编号
	
	private int doctorId;													//医生id
	private int patientId;												//病人id
	private String medicineName;								//药品名称
	private String method;													//用法
	private int dosage;													//单次用量
	private String frequence;												//用药频率
	private int totalCount;												//开药总量
	private Date recipeTime;											//开放时间
	
	
	
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
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
	public Date getRecipeTime() {
		return recipeTime;
	}
	public void setRecipeTime(Date recipeTime) {
		this.recipeTime = recipeTime;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
