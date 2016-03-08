package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午10:37:50
* 心理状态
*/
public class MentalState implements Serializable{

	private boolean nervous;						//紧张
	private boolean anxiety;						//焦虑
	private boolean despression;				//抑郁
	
	private String other;									//其他

	public boolean isNervous() {
		return nervous;
	}

	public void setNervous(boolean nervous) {
		this.nervous = nervous;
	}

	public boolean isAnxiety() {
		return anxiety;
	}

	public void setAnxiety(boolean anxiety) {
		this.anxiety = anxiety;
	}

	public boolean isDespression() {
		return despression;
	}

	public void setDespression(boolean despression) {
		this.despression = despression;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	
}
