package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午7:51:14
* 血压情况
*/
public class BloodPressure implements Serializable{

	private int caseHistoryId;										//病历号
	private int diseaseHistory;										//病程几年
	private String highBlood;											//最高血压
	private String commonBlood;								//平时血压
	private String lowBlood;											//最低血压
	
	private String bloodFeture;										//高血压特点
	private String cureEffact;											//目前用药疗效
	
	
	
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public int getDiseaseHistory() {
		return diseaseHistory;
	}
	public void setDiseaseHistory(int diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	public String getHighBlood() {
		return highBlood;
	}
	public void setHighBlood(String highBlood) {
		this.highBlood = highBlood;
	}
	public String getCommonBlood() {
		return commonBlood;
	}
	public void setCommonBlood(String commonBlood) {
		this.commonBlood = commonBlood;
	}
	public String getLowBlood() {
		return lowBlood;
	}
	public void setLowBlood(String lowBlood) {
		this.lowBlood = lowBlood;
	}
	public String getBloodFeture() {
		return bloodFeture;
	}
	public void setBloodFeture(String bloodFeture) {
		this.bloodFeture = bloodFeture;
	}
	public String getCureEffact() {
		return cureEffact;
	}
	public void setCureEffact(String cureEffact) {
		this.cureEffact = cureEffact;
	}
	
	
}
