package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午4:04:57
* 病人主诉信息
*/
public class ChiefComplaint implements Serializable{

	private int id;																				//主诉编号
	private List<String> chiefComplaintContext;					//主诉内容
	private int patientId;																//病人id
	private int caseHistoryId;														//病历编号
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getChiefComplaintContext() {
		return chiefComplaintContext;
	}
	public void setChiefComplaintContext(List<String> chiefComplaintContext) {
		this.chiefComplaintContext = chiefComplaintContext;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	
	
}
