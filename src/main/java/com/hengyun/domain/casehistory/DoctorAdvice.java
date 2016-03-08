package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 * 
 * 医嘱信息描述
 * 
 * */
public class DoctorAdvice implements Serializable{

	private int caseHistoryId;													//病历号
	private String commandTime;											//医嘱时间
	private String content;															//医嘱内容
	private String executeTime;												//执行时间
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public String getCommandTime() {
		return commandTime;
	}
	public void setCommandTime(String commandTime) {
		this.commandTime = commandTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}
	
	
}
