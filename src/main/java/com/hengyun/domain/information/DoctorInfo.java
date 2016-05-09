package com.hengyun.domain.information;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月21日 上午10:25:53
* 医生信息
*/
public class DoctorInfo implements Serializable{

	private int userId;								//用户ID
	//private String workNum;					//工号
	private String trueName;					//姓名
	private String sex;								//性别
	private String shortName;				//医院简称
	private String birthday;						//生日
	private String iconUrl;							//用户图像地址
	
	private String address;						//现住址
	private int age;									//用户年龄
	
	private String resume;						//简介

	/*
	 *  联系方式
	 * */
//	private String email;							//邮箱
	
//	private String mobilephone;			//手机号
	
	private String recordTime;							//记录时间

	
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}



	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
	
	
}
