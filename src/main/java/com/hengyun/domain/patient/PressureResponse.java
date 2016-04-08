package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PressureResponse implements Serializable{

	private List<BloodPressureInfo>  bloodPressureInfo= new ArrayList<BloodPressureInfo>();
	
	private String code;
	
	
	
	
	public List<BloodPressureInfo> getBloodPressureInfo() {
		return bloodPressureInfo;
	}
	public void setBloodPressureInfo(List<BloodPressureInfo> bloodPressureInfo) {
		this.bloodPressureInfo = bloodPressureInfo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
