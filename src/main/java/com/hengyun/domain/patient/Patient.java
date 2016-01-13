package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.information.GeneralPerson;

/*
 *  病人信息表
 * */
public class Patient  extends GeneralPerson implements Serializable{
	

	private List<Integer>			caseHistory;							//病历列表
	
	private List<Integer>			docters;							//病人的医生列表
	
	private List<Integer>			retreats;							//病人的回访列表

	public List<Integer> getCaseHistory() {
		return caseHistory;
	}

	public void setCaseHistory(List<Integer> caseHistory) {
		this.caseHistory = caseHistory;
	}

	public List<Integer> getDocters() {
		return docters;
	}

	public void setDocters(List<Integer> docters) {
		this.docters = docters;
	}

	public List<Integer> getRetreats() {
		return retreats;
	}

	public void setRetreats(List<Integer> retreats) {
		this.retreats = retreats;
	}
	

	
	
	

}
