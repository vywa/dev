package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/*
 *  病人回访信息
 * */
public class ReTreateInfo implements Serializable{
	
	private int 	id;												//回访id
	
	private int			docterId;								//医生id

	private int			patientId;							//回访病人id
	
	private Date		viewTime;								//回访时间
	
	private Date		receiveTime;						//处理时间
	
	private String   content;								//回访内容
	
	private String	status;									//回访状态(未处理，处理，过期)
	
	

	public int getDocterId() {
		return docterId;
	}

	public void setDocterId(int docterId) {
		this.docterId = docterId;
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

	public Date getViewTime() {
		return viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
