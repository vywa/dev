package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午3:48:15
* 病人生活习惯信息
*/
public class HabitInfo implements Serializable{

	private int patientId;									//用户id
	
	private List<HashMap<String,Object>> cigarette;								//吸烟
	private List<HashMap<String,Object>> wine;										//酗酒
	
	private degree eatFat;										//脂肪摄入量
	private degree eatSalt;									//盐摄入量
	private degree physicalMove;						//体力活动量
	private degree workPressure;						//工作压力
	
	public enum degree{									//程度
		many,
		moderate,
		little
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public List<HashMap<String, Object>> getCigarette() {
		return cigarette;
	}
	public void setCigarette(List<HashMap<String, Object>> cigarette) {
		this.cigarette = cigarette;
	}
	public List<HashMap<String, Object>> getWine() {
		return wine;
	}
	public void setWine(List<HashMap<String, Object>> wine) {
		this.wine = wine;
	}
	public degree getEatFat() {
		return eatFat;
	}
	public void setEatFat(degree eatFat) {
		this.eatFat = eatFat;
	}
	public degree getEatSalt() {
		return eatSalt;
	}
	public void setEatSalt(degree eatSalt) {
		this.eatSalt = eatSalt;
	}
	public degree getPhysicalMove() {
		return physicalMove;
	}
	public void setPhysicalMove(degree physicalMove) {
		this.physicalMove = physicalMove;
	}
	public degree getWorkPressure() {
		return workPressure;
	}
	public void setWorkPressure(degree workPressure) {
		this.workPressure = workPressure;
	}
	
	

	
}
