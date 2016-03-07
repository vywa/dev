package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 *  个人病史
 *  记录出生地及长期居留地，生活习惯及有无烟、酒、药物等嗜好，职业与工作条件及有无工业毒物、粉尘、放射性物质接触史，有无冶游史。
 * 
 * */
public class PersonalHistory implements Serializable{

	private String birthdaysite;
	private String liveAddress;
	private String habit;
	public String getBirthdaysite() {
		return birthdaysite;
	}
	public void setBirthdaysite(String birthdaysite) {
		this.birthdaysite = birthdaysite;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	
	
	
}
