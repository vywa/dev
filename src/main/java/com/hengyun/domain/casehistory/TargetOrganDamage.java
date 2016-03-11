package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:05:34
*靶器官损伤
*/
public class TargetOrganDamage implements Serializable{

	private int caseHistoryId;							//病历号
	private int targetOrganDamageId;			//id
	private boolean	 leftVentricularHypertrophy;					 //左心室肥厚；
	private boolean	 neckArteries;					//颈动脉内膜厚
	private boolean	 ankleArteries;					//踝动脉脉搏波速度
	private boolean	 limbArteries;					//臂动脉血压指数
	private boolean	 kidneyBall;					//肾小球滤过率降低
	private boolean	 urineProtein;					//微量蛋白尿
	
	
	
	public int getTargetOrganDamageId() {
		return targetOrganDamageId;
	}
	public void setTargetOrganDamageId(int targetOrganDamageId) {
		this.targetOrganDamageId = targetOrganDamageId;
	}
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public boolean isLeftVentricularHypertrophy() {
		return leftVentricularHypertrophy;
	}
	public void setLeftVentricularHypertrophy(boolean leftVentricularHypertrophy) {
		this.leftVentricularHypertrophy = leftVentricularHypertrophy;
	}
	public boolean isNeckArteries() {
		return neckArteries;
	}
	public void setNeckArteries(boolean neckArteries) {
		this.neckArteries = neckArteries;
	}
	public boolean isAnkleArteries() {
		return ankleArteries;
	}
	public void setAnkleArteries(boolean ankleArteries) {
		this.ankleArteries = ankleArteries;
	}
	public boolean isLimbArteries() {
		return limbArteries;
	}
	public void setLimbArteries(boolean limbArteries) {
		this.limbArteries = limbArteries;
	}
	public boolean isKidneyBall() {
		return kidneyBall;
	}
	public void setKidneyBall(boolean kidneyBall) {
		this.kidneyBall = kidneyBall;
	}
	public boolean isUrineProtein() {
		return urineProtein;
	}
	public void setUrineProtein(boolean urineProtein) {
		this.urineProtein = urineProtein;
	}
	
	
}
