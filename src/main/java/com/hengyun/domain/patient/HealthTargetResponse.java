package com.hengyun.domain.patient;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午4:21:53
* 健康目标返回类
*/
public class HealthTargetResponse extends ResponseCode{

	private int patientId;												//病人id
	private String targetHighBloodPressure;					//高血压目标
	private String targetLowBloodPressure;					//低血压目标
	
	private String zero;													//凌晨降糖目标
	private String beforeBreakfast;									//早餐前血糖目标
	private String afterBreakfast;										//早餐后血糖目标
	private String beforeLunch;											//午餐前血糖目标
	private String afterLunch;												//午餐后血糖目标
	private String beforeSupper;										//晚饭前目标
	private String afterSupper;											//晚饭后目标
	private String beforeSleep;											//睡前目标
	private String random;									//随机测量目标
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getTargetHighBloodPressure() {
		return targetHighBloodPressure;
	}
	public void setTargetHighBloodPressure(String targetHighBloodPressure) {
		this.targetHighBloodPressure = targetHighBloodPressure;
	}
	public String getTargetLowBloodPressure() {
		return targetLowBloodPressure;
	}
	public void setTargetLowBloodPressure(String targetLowBloodPressure) {
		this.targetLowBloodPressure = targetLowBloodPressure;
	}
	public String getZero() {
		return zero;
	}
	public void setZero(String zero) {
		this.zero = zero;
	}
	public String getBeforeBreakfast() {
		return beforeBreakfast;
	}
	public void setBeforeBreakfast(String beforeBreakfast) {
		this.beforeBreakfast = beforeBreakfast;
	}
	public String getAfterBreakfast() {
		return afterBreakfast;
	}
	public void setAfterBreakfast(String afterBreakfast) {
		this.afterBreakfast = afterBreakfast;
	}
	public String getBeforeLunch() {
		return beforeLunch;
	}
	public void setBeforeLunch(String beforeLunch) {
		this.beforeLunch = beforeLunch;
	}
	public String getAfterLunch() {
		return afterLunch;
	}
	public void setAfterLunch(String afterLunch) {
		this.afterLunch = afterLunch;
	}
	public String getBeforeSupper() {
		return beforeSupper;
	}
	public void setBeforeSupper(String beforeSupper) {
		this.beforeSupper = beforeSupper;
	}
	public String getAfterSupper() {
		return afterSupper;
	}
	public void setAfterSupper(String afterSupper) {
		this.afterSupper = afterSupper;
	}
	public String getBeforeSleep() {
		return beforeSleep;
	}
	public void setBeforeSleep(String beforeSleep) {
		this.beforeSleep = beforeSleep;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	

	
}
