package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午3:50:37
* 病人基本信息
*/
public class PatientInfo implements Serializable{
/*
	姓名，性别，年龄，婚姻，民族，职业，出生地，
	现住址，工作单位，身份证号，邮政编码，电话，
	入院时间，记录时间，病史叙述者（注明可靠程度）
	*/
	private int id;
	private String patientName;			
	private String sex;		
	private int age;
	private boolean marrage;
	private String ration;
	private String hometown;
	private String department;
	private String workplace;
	private String idCard;
	private String potCode;
	private String telephone;
	private Date entryHospital;
	private Date recordTime;
	private String tellerName;
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarrage() {
		return marrage;
	}
	public void setMarrage(boolean marrage) {
		this.marrage = marrage;
	}
	public String getRation() {
		return ration;
	}
	public void setRation(String ration) {
		this.ration = ration;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPotCode() {
		return potCode;
	}
	public void setPotCode(String potCode) {
		this.potCode = potCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getEntryHospital() {
		return entryHospital;
	}
	public void setEntryHospital(Date entryHospital) {
		this.entryHospital = entryHospital;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public String getTellerName() {
		return tellerName;
	}
	public void setTellerName(String tellerName) {
		this.tellerName = tellerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
