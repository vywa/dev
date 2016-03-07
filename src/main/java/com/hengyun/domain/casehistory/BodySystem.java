package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午5:01:12
* 系统各系统情况
*/
public class BodySystem implements Serializable{

	private String breathSystem;
	private String bloodCycleSystem;
	private String digestSystem;
	public String getBreathSystem() {
		return breathSystem;
	}
	public void setBreathSystem(String breathSystem) {
		this.breathSystem = breathSystem;
	}
	public String getBloodCycleSystem() {
		return bloodCycleSystem;
	}
	public void setBloodCycleSystem(String bloodCycleSystem) {
		this.bloodCycleSystem = bloodCycleSystem;
	}
	public String getDigestSystem() {
		return digestSystem;
	}
	public void setDigestSystem(String digestSystem) {
		this.digestSystem = digestSystem;
	}
	
	
}
