package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 * 
 *  既往病史
 *  
 * */
public class PastDiseaseHistory implements Serializable{

	private int caseHistoryId;									//病历id
	
	private boolean fatException;								//脂肪异常
	private boolean gout;												//痛风
	private boolean urineSour;									//尿酸高
	private boolean proteinUrine;								//蛋白尿
	private String coronary;											//冠心病
	private boolean leftHeartFat;										//左心室肥厚
	private boolean heartSenescense;							//心衰
	private boolean neckArteriesHarden;						//颈动脉硬化
	private boolean anemia;										//贫血
	private boolean stamach;										//胃病
	
	private String brainVessel;										//脑血管病
	private String kidney;												//肾病
	private String kidneyArteriesNarrow;					//肾动脉狭窄
	private String eyeDisease;										//眼病
	
	private boolean asthma;										//哮喘
	private boolean breathSleepStop;						//睡眠呼吸暂停
	private boolean cervicalSpondylosis;					//颈椎病
	private String bile;														//胆道疾病
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public boolean isFatException() {
		return fatException;
	}
	public void setFatException(boolean fatException) {
		this.fatException = fatException;
	}
	public boolean isGout() {
		return gout;
	}
	public void setGout(boolean gout) {
		this.gout = gout;
	}
	public boolean isUrineSour() {
		return urineSour;
	}
	public void setUrineSour(boolean urineSour) {
		this.urineSour = urineSour;
	}
	public boolean isProteinUrine() {
		return proteinUrine;
	}
	public void setProteinUrine(boolean proteinUrine) {
		this.proteinUrine = proteinUrine;
	}
	public String getCoronary() {
		return coronary;
	}
	public void setCoronary(String coronary) {
		this.coronary = coronary;
	}
	public boolean isLeftHeartFat() {
		return leftHeartFat;
	}
	public void setLeftHeartFat(boolean leftHeartFat) {
		this.leftHeartFat = leftHeartFat;
	}
	public boolean isHeartSenescense() {
		return heartSenescense;
	}
	public void setHeartSenescense(boolean heartSenescense) {
		this.heartSenescense = heartSenescense;
	}
	public boolean isNeckArteriesHarden() {
		return neckArteriesHarden;
	}
	public void setNeckArteriesHarden(boolean neckArteriesHarden) {
		this.neckArteriesHarden = neckArteriesHarden;
	}
	public boolean isAnemia() {
		return anemia;
	}
	public void setAnemia(boolean anemia) {
		this.anemia = anemia;
	}
	public boolean isStamach() {
		return stamach;
	}
	public void setStamach(boolean stamach) {
		this.stamach = stamach;
	}
	public String getBrainVessel() {
		return brainVessel;
	}
	public void setBrainVessel(String brainVessel) {
		this.brainVessel = brainVessel;
	}
	public String getKidney() {
		return kidney;
	}
	public void setKidney(String kidney) {
		this.kidney = kidney;
	}
	public String getKidneyArteriesNarrow() {
		return kidneyArteriesNarrow;
	}
	public void setKidneyArteriesNarrow(String kidneyArteriesNarrow) {
		this.kidneyArteriesNarrow = kidneyArteriesNarrow;
	}
	public String getEyeDisease() {
		return eyeDisease;
	}
	public void setEyeDisease(String eyeDisease) {
		this.eyeDisease = eyeDisease;
	}
	public boolean isAsthma() {
		return asthma;
	}
	public void setAsthma(boolean asthma) {
		this.asthma = asthma;
	}
	public boolean isBreathSleepStop() {
		return breathSleepStop;
	}
	public void setBreathSleepStop(boolean breathSleepStop) {
		this.breathSleepStop = breathSleepStop;
	}
	public boolean isCervicalSpondylosis() {
		return cervicalSpondylosis;
	}
	public void setCervicalSpondylosis(boolean cervicalSpondylosis) {
		this.cervicalSpondylosis = cervicalSpondylosis;
	}
	public String getBile() {
		return bile;
	}
	public void setBile(String bile) {
		this.bile = bile;
	}

}
