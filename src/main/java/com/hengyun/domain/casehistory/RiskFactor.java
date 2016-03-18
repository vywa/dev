package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午10:57:06
* 危险因素
*/
public class RiskFactor implements Serializable{

	//private int caseHistoryId;									//病历号
	
	//private int riskFactorId;										//id
	private int hightBloodPressure;						//高血压几级
	private int age;														//年龄
	private boolean cigerate;									//吸烟
	private boolean suggerEndure;						//糖耐量受损
	private boolean bloodFatException;				//血脂异常
	private boolean vesselherit;								//早发心血管病家族史
	private boolean fat;												//肥胖或腹型肥胖
	
	private boolean 	hcy;										//血同型半胱氨酸升高
	
	private boolean hsCRP;										//高敏c反应蛋白
	private boolean physicalActivity;					//体力活动
	
	

	
	public int getHightBloodPressure() {
		return hightBloodPressure;
	}
	public void setHightBloodPressure(int hightBloodPressure) {
		this.hightBloodPressure = hightBloodPressure;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isCigerate() {
		return cigerate;
	}
	public void setCigerate(boolean cigerate) {
		this.cigerate = cigerate;
	}
	public boolean isSuggerEndure() {
		return suggerEndure;
	}
	public void setSuggerEndure(boolean suggerEndure) {
		this.suggerEndure = suggerEndure;
	}
	public boolean isBloodFatException() {
		return bloodFatException;
	}
	public void setBloodFatException(boolean bloodFatException) {
		this.bloodFatException = bloodFatException;
	}
	public boolean isVesselherit() {
		return vesselherit;
	}
	public void setVesselherit(boolean vesselherit) {
		this.vesselherit = vesselherit;
	}
	public boolean isFat() {
		return fat;
	}
	public void setFat(boolean fat) {
		this.fat = fat;
	}
	public boolean isHcy() {
		return hcy;
	}
	public void setHcy(boolean hcy) {
		this.hcy = hcy;
	}
	public boolean isHsCRP() {
		return hsCRP;
	}
	public void setHsCRP(boolean hsCRP) {
		this.hsCRP = hsCRP;
	}
	public boolean isPhysicalActivity() {
		return physicalActivity;
	}
	public void setPhysicalActivity(boolean physicalActivity) {
		this.physicalActivity = physicalActivity;
	}
	
	
}
