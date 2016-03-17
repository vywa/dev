package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 
 *  诊断结果
 *  
 * */
public class Diagnosis implements Serializable{

	private int caseHistoryId;									//病历id
	
	private int diagnosisId;										//诊断id
	
	private List<String> cotent= new ArrayList<String>();									//诊断内容
	
	
	private DangerLevel dangerLevel;						//危险分层
	
	private Date recordDate;										//记录时间
	

	public int getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public DangerLevel getDangerLevel() {
		return dangerLevel;
	}
	public void setDangerLevel(DangerLevel dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public List<String> getCotent() {
		return cotent;
	}
	public void setCotent(List<String> cotent) {
		this.cotent = cotent;
	}
	
	public enum DangerLevel {
		little_danger,
		moderate_danger,
		more_danger,
		most_danger
	}
	
}
