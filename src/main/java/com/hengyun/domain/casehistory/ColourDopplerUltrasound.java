package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:54:34
* 彩超
*/
public class ColourDopplerUltrasound implements Serializable{

	private int sheetId;									//化验单id
	
	private String brainColour;						//脑彩
	private String heart;									//心脏
	private String neckArtery;						//颈动脉
	private String fiveOrgan;							//五脏
	private String thyroid;								//甲状腺
	private String womb;									//子宫附件
	private String breast;									//乳腺
	private String prostate;							//前列腺
	private String upperLimbBloodVessel;			//上肢血管
	private String lowLimbBloodVessel;				//下肢血管
	private String sideVessel;							//单侧血管
	
	
	public int getSheetId() {
		return sheetId;
	}
	public void setSheetId(int sheetId) {
		this.sheetId = sheetId;
	}
	public String getBrainColour() {
		return brainColour;
	}
	public void setBrainColour(String brainColour) {
		this.brainColour = brainColour;
	}
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	public String getNeckArtery() {
		return neckArtery;
	}
	public void setNeckArtery(String neckArtery) {
		this.neckArtery = neckArtery;
	}
	public String getFiveOrgan() {
		return fiveOrgan;
	}
	public void setFiveOrgan(String fiveOrgan) {
		this.fiveOrgan = fiveOrgan;
	}
	public String getThyroid() {
		return thyroid;
	}
	public void setThyroid(String thyroid) {
		this.thyroid = thyroid;
	}
	public String getWomb() {
		return womb;
	}
	public void setWomb(String womb) {
		this.womb = womb;
	}
	public String getBreast() {
		return breast;
	}
	public void setBreast(String breast) {
		this.breast = breast;
	}
	public String getProstate() {
		return prostate;
	}
	public void setProstate(String prostate) {
		this.prostate = prostate;
	}
	public String getUpperLimbBloodVessel() {
		return upperLimbBloodVessel;
	}
	public void setUpperLimbBloodVessel(String upperLimbBloodVessel) {
		this.upperLimbBloodVessel = upperLimbBloodVessel;
	}
	public String getLowLimbBloodVessel() {
		return lowLimbBloodVessel;
	}
	public void setLowLimbBloodVessel(String lowLimbBloodVessel) {
		this.lowLimbBloodVessel = lowLimbBloodVessel;
	}
	public String getSideVessel() {
		return sideVessel;
	}
	public void setSideVessel(String sideVessel) {
		this.sideVessel = sideVessel;
	}
	
	
}
