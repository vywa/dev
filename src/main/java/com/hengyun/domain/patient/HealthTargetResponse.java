package com.hengyun.domain.patient;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午4:21:53
* 健康目标返回类
*/
public class HealthTargetResponse extends ResponseCode{

	private int patientId;												//病人id
	private int targetHighBloodPressure;					//高血压目标
	private int targetLowBloodPressure;					//低血压目标
	
	private int zero;													//凌晨降糖目标
	private int beforeBreakfast;									//早餐前血糖目标
	private int afterBreakfast;										//早餐后血糖目标
	private int beforeLunch;											//午餐前血糖目标
	private int afterLunch;												//午餐后血糖目标
	private int beforeSupper;										//晚饭前目标
	private int afterSupper;											//晚饭后目标
	private int beforeSleep;											//睡前目标
	private int random;									//随机测量目标
	
	
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getRandom() {
		return random;
	}
	public void setRandom(int random) {
		this.random = random;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getTargetHighBloodPressure() {
		return targetHighBloodPressure;
	}
	public void setTargetHighBloodPressure(int targetHighBloodPressure) {
		this.targetHighBloodPressure = targetHighBloodPressure;
	}
	public int getTargetLowBloodPressure() {
		return targetLowBloodPressure;
	}
	public void setTargetLowBloodPressure(int targetLowBloodPressure) {
		this.targetLowBloodPressure = targetLowBloodPressure;
	}
	
	public int getBeforeBreakfast() {
		return beforeBreakfast;
	}
	public void setBeforeBreakfast(int beforeBreakfast) {
		this.beforeBreakfast = beforeBreakfast;
	}
	public int getAfterBreakfast() {
		return afterBreakfast;
	}
	public void setAfterBreakfast(int afterBreakfast) {
		this.afterBreakfast = afterBreakfast;
	}
	public int getBeforeLunch() {
		return beforeLunch;
	}
	public void setBeforeLunch(int beforeLunch) {
		this.beforeLunch = beforeLunch;
	}
	public int getAfterLunch() {
		return afterLunch;
	}
	public void setAfterLunch(int afterLunch) {
		this.afterLunch = afterLunch;
	}
	public int getBeforeSupper() {
		return beforeSupper;
	}
	public void setBeforeSupper(int beforeSupper) {
		this.beforeSupper = beforeSupper;
	}
	public int getAfterSupper() {
		return afterSupper;
	}
	public void setAfterSupper(int afterSupper) {
		this.afterSupper = afterSupper;
	}
	public int getBeforeSleep() {
		return beforeSleep;
	}
	public void setBeforeSleep(int beforeSleep) {
		this.beforeSleep = beforeSleep;
	}
	
	public HealthTargetResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
