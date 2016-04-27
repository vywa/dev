package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SuggerResponse implements Serializable{

	private List<BloodSuggerInfo> bloodSuggerInfo= new ArrayList<BloodSuggerInfo>();
	private String code;
	private HealthTarget healthTarget;
	private HealthLine healthLine;
	
	
	
	public HealthLine getHealthLine() {
		return healthLine;
	}
	public void setHealthLine(HealthLine healthLine) {
		this.healthLine = healthLine;
	}
	public HealthTarget getHealthTarget() {
		return healthTarget;
	}
	public void setHealthTarget(HealthTarget healthTarget) {
		this.healthTarget = healthTarget;
	}
	public List<BloodSuggerInfo> getBloodSuggerInfo() {
		return bloodSuggerInfo;
	}
	public void setBloodSuggerInfo(List<BloodSuggerInfo> bloodSuggerInfo) {
		this.bloodSuggerInfo = bloodSuggerInfo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
