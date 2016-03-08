package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:55:33
* 血生化
*/
public class BloodBiochemical implements Serializable{

	private int sheetId;														//化验单id
	private String repadBloodSugger;							//快速血糖
	private String venousBlood;										//静脉血糖
	private String suggerBloodProtein;							//糖化血红蛋白
	private String bloodFat;												//血脂（四项）
	private String smallLiver;												//小肝
	private String bigLiver;													//大肝
	private String kidney;													//肾功
	private String totalBilirubin;										//总胆红素
	private String myocardialEnzyme;							//心肌酶
	public int getSheetId() {
		return sheetId;
	}
	public void setSheetId(int sheetId) {
		this.sheetId = sheetId;
	}
	public String getRepadBloodSugger() {
		return repadBloodSugger;
	}
	public void setRepadBloodSugger(String repadBloodSugger) {
		this.repadBloodSugger = repadBloodSugger;
	}
	public String getVenousBlood() {
		return venousBlood;
	}
	public void setVenousBlood(String venousBlood) {
		this.venousBlood = venousBlood;
	}
	public String getSuggerBloodProtein() {
		return suggerBloodProtein;
	}
	public void setSuggerBloodProtein(String suggerBloodProtein) {
		this.suggerBloodProtein = suggerBloodProtein;
	}
	public String getBloodFat() {
		return bloodFat;
	}
	public void setBloodFat(String bloodFat) {
		this.bloodFat = bloodFat;
	}
	public String getSmallLiver() {
		return smallLiver;
	}
	public void setSmallLiver(String smallLiver) {
		this.smallLiver = smallLiver;
	}
	public String getBigLiver() {
		return bigLiver;
	}
	public void setBigLiver(String bigLiver) {
		this.bigLiver = bigLiver;
	}
	public String getKidney() {
		return kidney;
	}
	public void setKidney(String kidney) {
		this.kidney = kidney;
	}
	public String getTotalBilirubin() {
		return totalBilirubin;
	}
	public void setTotalBilirubin(String totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}
	public String getMyocardialEnzyme() {
		return myocardialEnzyme;
	}
	public void setMyocardialEnzyme(String myocardialEnzyme) {
		this.myocardialEnzyme = myocardialEnzyme;
	}
	
	
}
