package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午3:48:15
* 病人生活习惯信息
*/
public class HabitInfo implements Serializable{

	private int userId;											//用户id
	
	private String cigarette;								//吸烟
	private int age;											//年龄
	private String wine;										//酗酒
	private String salt;											//食盐
	private int weight;									//体重
	private boolean inherit;									//遗传
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	public String getCigarette() {
		return cigarette;
	}
	public void setCigarette(String cigarette) {
		this.cigarette = cigarette;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isInherit() {
		return inherit;
	}
	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}
	public String getWine() {
		return wine;
	}
	public void setWine(String wine) {
		this.wine = wine;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	
		return super.toString();
	}
	
	
}
