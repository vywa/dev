package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.List;

/*
 * 
 *  诊断结果
 *  
 * */
public class Diagnosis implements Serializable{

	private int caseHistoryId;									//病历id
	private List<String> cotent;									//诊断项目
	private String level;													//危险分层
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
