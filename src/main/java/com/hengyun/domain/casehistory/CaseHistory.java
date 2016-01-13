package com.hengyun.domain.casehistory;

import java.io.Serializable;

import com.hengyun.domain.information.Information;


/*
 * 	病历基本信息，包括门诊病历首页，病历记录，化验单（检查报告），医学影像检查资料
 * */

public class CaseHistory implements Serializable{

	
	private int id;															//病历编号
	
	private int patientId;											//病人id
	
	private int docterId;												//医生id
	
	private String catagory;										//病历类型(门诊，急诊，住院)
	
	private CaseHistoryPreface caseHistoryPreface;				//门诊病历首页
	
	private CaseHistoryContent caseHistoryContent;			//病历记录
	
	private String 					status;										//病历状态（正常，冻结）

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDocterId() {
		return docterId;
	}

	public void setDocterId(int docterId) {
		this.docterId = docterId;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public CaseHistoryPreface getCaseHistoryPreface() {
		return caseHistoryPreface;
	}

	public void setCaseHistoryPreface(CaseHistoryPreface caseHistoryPreface) {
		this.caseHistoryPreface = caseHistoryPreface;
	}

	public CaseHistoryContent getCaseHistoryContent() {
		return caseHistoryContent;
	}

	public void setCaseHistoryContent(CaseHistoryContent caseHistoryContent) {
		this.caseHistoryContent = caseHistoryContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
