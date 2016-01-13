package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/*
 *   门诊病历首页
 *   
 *   
 * */

public class CaseHistoryPreface implements Serializable{

	private String name;										//患者姓名
	private String sex;											//性别
	private Date birthday;									//出生年月
	private String nation;									//民族
	private String marriage;								//婚姻状况
	private String occupation;							//职业
	private String company;								//工作单位
	private String address;									//住址
	private  String drugAllergy;							//药物过敏史
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDrugAllergy() {
		return drugAllergy;
	}
	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}
	
	
}
