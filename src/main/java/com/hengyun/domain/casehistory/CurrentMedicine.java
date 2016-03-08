package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:34:24
* 目前用药
*/
public class CurrentMedicine implements Serializable{

	private int caseHistoryId;														//病历
	private List<String>  highBooldMedicine;							//高血压
	private List<String> diabetesMellitus;									//糖尿病
	private String sideEffects;														//副作用
	private List<String> otherDiseaseMedicines;					//其他疾病用药
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public List<String> getHighBooldMedicine() {
		return highBooldMedicine;
	}
	public void setHighBooldMedicine(List<String> highBooldMedicine) {
		this.highBooldMedicine = highBooldMedicine;
	}
	public List<String> getDiabetesMellitus() {
		return diabetesMellitus;
	}
	public void setDiabetesMellitus(List<String> diabetesMellitus) {
		this.diabetesMellitus = diabetesMellitus;
	}
	public String getSideEffects() {
		return sideEffects;
	}
	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}
	public List<String> getOtherDiseaseMedicines() {
		return otherDiseaseMedicines;
	}
	public void setOtherDiseaseMedicines(List<String> otherDiseaseMedicines) {
		this.otherDiseaseMedicines = otherDiseaseMedicines;
	}
	
	
	
}
