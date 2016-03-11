package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 
 * 医嘱信息描述
 * 
 * */
public class DoctorAdvice implements Serializable{

	private int caseHistoryId;													//病历号
	private int doctorAdviceId;												//医嘱id
	private Date commandTime;											//医嘱时间
	private String content;															//医嘱内容
	private List<Recipe> recipes;												//处方列表
	private Date executeTime;												//执行时间
	
	
	
	public int getDoctorAdviceId() {
		return doctorAdviceId;
	}
	public void setDoctorAdviceId(int doctorAdviceId) {
		this.doctorAdviceId = doctorAdviceId;
	}
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}

	public Date getCommandTime() {
		return commandTime;
	}
	public void setCommandTime(Date commandTime) {
		this.commandTime = commandTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public Date getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	
	
}
