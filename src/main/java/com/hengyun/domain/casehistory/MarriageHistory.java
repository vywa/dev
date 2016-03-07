package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 *  婚育史，月经史。婚姻状况、结婚年龄、配偶健康状况、有无子女等。
 *  女性患者记录初潮年龄、行经期天数 、间隔天数、末次月经时间(或闭经年龄)，月经量、痛经及生育等情况。
 * 
 * */
public class MarriageHistory implements Serializable{

	private String marrage;
	private String menstruation;
	public String getMarrage() {
		return marrage;
	}
	public void setMarrage(String marrage) {
		this.marrage = marrage;
	}
	public String getMenstruation() {
		return menstruation;
	}
	public void setMenstruation(String menstruation) {
		this.menstruation = menstruation;
	}
	
}
