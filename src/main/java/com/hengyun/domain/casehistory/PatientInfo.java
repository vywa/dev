package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午3:50:37
* 病人基本信息
*/
public class PatientInfo implements Serializable{

	private int id;																				//病人id
	
	private String patientName;													//姓名
	private String sex;																		//性别
	private int age;																			//年龄
	
	private String ration;																	//民族
	private String work;																	//职业
	private String education;															//文化程度
	
	
	private String idCard;																//身份证号
	private String workAddress;													//单位地址
	private String telephone;															//电话
	
	private String medicineCost;													//费用
	private String emergencyPerson;											//紧急联系人
	private String emergencyTel;													//紧急联系人电话
	
	private String infoSource;														//信息来源
	private String introducer;														//介绍人
	private int introducerCaseHistoryId;									//介绍人病历号
	
	private CostPay catagory;															//患者分类
	private String other;																	//其他
	private String chineseCure;														//中药治疗
	
	private String costPay;																//医保报销
	
	private boolean westChineseCure;									//中西医结合
	
	
	public enum CostPay{
		employee_health_insurance,
		residents_medical_insurance,
		leader_medical_insurance,
		controy_count,
		new_controy
	}
	
	public CostPay getCatagory() {
		return catagory;
	}
	public void setCatagory(CostPay catagory) {
		this.catagory = catagory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getRation() {
		return ration;
	}
	public void setRation(String ration) {
		this.ration = ration;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(String medicineCost) {
		this.medicineCost = medicineCost;
	}
	public String getEmergencyPerson() {
		return emergencyPerson;
	}
	public void setEmergencyPerson(String emergencyPerson) {
		this.emergencyPerson = emergencyPerson;
	}
	public String getEmergencyTel() {
		return emergencyTel;
	}
	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}
	public String getInfoSource() {
		return infoSource;
	}
	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	public int getIntroducerCaseHistoryId() {
		return introducerCaseHistoryId;
	}
	public void setIntroducerCaseHistoryId(int introducerCaseHistoryId) {
		this.introducerCaseHistoryId = introducerCaseHistoryId;
	}
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getChineseCure() {
		return chineseCure;
	}
	public void setChineseCure(String chineseCure) {
		this.chineseCure = chineseCure;
	}
	public String getCostPay() {
		return costPay;
	}
	public void setCostPay(String costPay) {
		this.costPay = costPay;
	}
	public boolean isWestChineseCure() {
		return westChineseCure;
	}
	public void setWestChineseCure(boolean westChineseCure) {
		this.westChineseCure = westChineseCure;
	}
	
	
	
	
	
	
	
	
}
