package com.hengyun.domain.docter;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.information.GeneralPerson;

/*
 * 医生信息表 
 * */


public class Docter extends GeneralPerson implements Serializable{

	private List<Integer>			caseHistory;									//医生参与的病历	

	private List<Integer>				patients;										//医生的病人列表
	
	private List<Integer>				retreats;										//回访列表
	
	

	public List<Integer> getRetreats() {
		return retreats;
	}

	public void setRetreats(List<Integer> retreats) {
		this.retreats = retreats;
	}

	public List<Integer> getCaseHistory() {
		return caseHistory;
	}

	public void setCaseHistory(List<Integer> caseHistory) {
		this.caseHistory = caseHistory;
	}

	public List<Integer> getPatients() {
		return patients;
	}

	public void setPatients(List<Integer> patients) {
		this.patients = patients;
	}
	

}
