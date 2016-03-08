package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:18:59
* 伴临床疾患
*/
public class AffiliatedClinicalDisease implements Serializable{

	private int caseHistoryId;													//病历号
   private boolean 	cerebralVascularDisease;					//脑血管病
   private boolean cardiovascularDisease;						//心血管病
   private boolean kidneyDisease;										//肾脏疾病
   private boolean peripheralVascularDisease;				//外周血管病
   private boolean retinopathy;											//视网膜病变
   private boolean diabetesMelliitus;									//糖尿病
public int getCaseHistoryId() {
	return caseHistoryId;
}
public void setCaseHistoryId(int caseHistoryId) {
	this.caseHistoryId = caseHistoryId;
}
public boolean isCerebralVascularDisease() {
	return cerebralVascularDisease;
}
public void setCerebralVascularDisease(boolean cerebralVascularDisease) {
	this.cerebralVascularDisease = cerebralVascularDisease;
}
public boolean isCardiovascularDisease() {
	return cardiovascularDisease;
}
public void setCardiovascularDisease(boolean cardiovascularDisease) {
	this.cardiovascularDisease = cardiovascularDisease;
}
public boolean isKidneyDisease() {
	return kidneyDisease;
}
public void setKidneyDisease(boolean kidneyDisease) {
	this.kidneyDisease = kidneyDisease;
}
public boolean isPeripheralVascularDisease() {
	return peripheralVascularDisease;
}
public void setPeripheralVascularDisease(boolean peripheralVascularDisease) {
	this.peripheralVascularDisease = peripheralVascularDisease;
}
public boolean isRetinopathy() {
	return retinopathy;
}
public void setRetinopathy(boolean retinopathy) {
	this.retinopathy = retinopathy;
}
public boolean isDiabetesMelliitus() {
	return diabetesMelliitus;
}
public void setDiabetesMelliitus(boolean diabetesMelliitus) {
	this.diabetesMelliitus = diabetesMelliitus;
}
   
   
   
}
