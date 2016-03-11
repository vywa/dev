package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午11:34:33
* 处方类
*/
public class Recipe implements Serializable{

	private int doctorAdviceId;									//医嘱id
	
	private int recipeId;													//处方编号
	private String medicineName;								//药品名称
	private String usage;													//用法
	private int dosage;													//单次用量
	private int frequence;												//用药频率
	private int dayCount;												//使用天数
	private int totalCount;												//开药总量
	
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getDoctorAdviceId() {
		return doctorAdviceId;
	}
	public void setDoctorAdviceId(int doctorAdviceId) {
		this.doctorAdviceId = doctorAdviceId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
