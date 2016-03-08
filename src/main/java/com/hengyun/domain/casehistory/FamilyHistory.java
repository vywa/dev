package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.List;

/*
 *  家族病史
 *  父母、兄弟、姐妹健康状况，有无与患者类似疾病，有无家族遗传倾向的疾病。
 * 
 * */
public class FamilyHistory implements Serializable{

	private int caseHistoryId;											//病历id
	
	private List<String> highBlood;									//父母，兄弟姐妹
	private int bloodPressure;											//高血压病人数
	private int totalCount;													//总人数
	
	private List<String> bloodSugger;							//糖尿病
	private int suggerCount;												//糖尿病人数
	
	private boolean coronaryDisease;							//冠心病
	private boolean anginaPectoris;								//心绞痛
	private boolean myocardialInfarction;					//心梗
	private boolean suddenCardiacDeath;					//心源性猝死
	private boolean cerebralInfarction;						//脑梗
	private boolean brainBlood;									//脑出血
	
	private boolean tia;														//
	private boolean cycleVessel;									//外周血管病
	private boolean bloodKidney;									//高血压肾病
	private boolean diabetic;											//糖尿病
	
	private int earliestAge;													//最早年龄
	private boolean dyslipidemia;									//血脂异常
	
	private String instruction;											//说明

	
	
	public int getCaseHistoryId() {
		return caseHistoryId;
	}


	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}


	public List<String> getHighBlood() {
		return highBlood;
	}

	
	public void setHighBlood(List<String> highBlood) {
		this.highBlood = highBlood;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<String> getBloodSugger() {
		return bloodSugger;
	}

	public void setBloodSugger(List<String> bloodSugger) {
		this.bloodSugger = bloodSugger;
	}

	public int getSuggerCount() {
		return suggerCount;
	}

	public void setSuggerCount(int suggerCount) {
		this.suggerCount = suggerCount;
	}

	public boolean isCoronaryDisease() {
		return coronaryDisease;
	}

	public void setCoronaryDisease(boolean coronaryDisease) {
		this.coronaryDisease = coronaryDisease;
	}

	public boolean isAnginaPectoris() {
		return anginaPectoris;
	}

	public void setAnginaPectoris(boolean anginaPectoris) {
		this.anginaPectoris = anginaPectoris;
	}

	public boolean isMyocardialInfarction() {
		return myocardialInfarction;
	}

	public void setMyocardialInfarction(boolean myocardialInfarction) {
		this.myocardialInfarction = myocardialInfarction;
	}

	public boolean isSuddenCardiacDeath() {
		return suddenCardiacDeath;
	}

	public void setSuddenCardiacDeath(boolean suddenCardiacDeath) {
		this.suddenCardiacDeath = suddenCardiacDeath;
	}

	public boolean isCerebralInfarction() {
		return cerebralInfarction;
	}

	public void setCerebralInfarction(boolean cerebralInfarction) {
		this.cerebralInfarction = cerebralInfarction;
	}

	public boolean isBrainBlood() {
		return brainBlood;
	}

	public void setBrainBlood(boolean brainBlood) {
		this.brainBlood = brainBlood;
	}

	public boolean isTia() {
		return tia;
	}

	public void setTia(boolean tia) {
		this.tia = tia;
	}

	public boolean isCycleVessel() {
		return cycleVessel;
	}

	public void setCycleVessel(boolean cycleVessel) {
		this.cycleVessel = cycleVessel;
	}

	public boolean isBloodKidney() {
		return bloodKidney;
	}

	public void setBloodKidney(boolean bloodKidney) {
		this.bloodKidney = bloodKidney;
	}

	public boolean isDiabetic() {
		return diabetic;
	}

	public void setDiabetic(boolean diabetic) {
		this.diabetic = diabetic;
	}

	public int getEarliestAge() {
		return earliestAge;
	}

	public void setEarliestAge(int earliestAge) {
		this.earliestAge = earliestAge;
	}

	public boolean isDyslipidemia() {
		return dyslipidemia;
	}

	public void setDyslipidemia(boolean dyslipidemia) {
		this.dyslipidemia = dyslipidemia;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
}
