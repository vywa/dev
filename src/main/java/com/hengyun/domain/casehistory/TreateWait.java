package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/*
 *  等待就诊
 * 
 * */
public class TreateWait implements Serializable{

	private int id;								//就诊编号
	
	private int patientId;				//病人id;
	
	private int	docterId;					//医生id;
	
	private Date applyTime;			//挂号时间
	
	private Date handleTime;			//就诊时间
	
	private String status;					//状态（等待，就诊，过期）
	

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

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

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
