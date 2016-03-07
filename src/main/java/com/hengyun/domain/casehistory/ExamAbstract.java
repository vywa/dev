package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午6:06:10
* 检查摘要
*/
public class ExamAbstract implements Serializable{

	private String positive;						//阳性
	private String negative;						//阴性
	private String neutrality;					//中性
	public String getPositive() {
		return positive;
	}
	public void setPositive(String positive) {
		this.positive = positive;
	}
	public String getNegative() {
		return negative;
	}
	public void setNegative(String negative) {
		this.negative = negative;
	}
	public String getNeutrality() {
		return neutrality;
	}
	public void setNeutrality(String neutrality) {
		this.neutrality = neutrality;
	}
	
	
	
	
}
