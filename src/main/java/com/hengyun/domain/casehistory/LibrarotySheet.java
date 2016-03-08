package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午11:47:42
* 化验单
*/
public class LibrarotySheet implements Serializable{

	private int sheetId;																	// 化验单id
	private String name;																	//病人名字
	private String sex;																		//性别
	private int age;																			//年龄
	private Date birthday;																//生日
	private int caseHistoryId;														//病历编号
	private int height;																		//身高
	private int weight;																		//体重
	private float waistline;																//腰围
	private String level;																		//会员等级(金卡，银卡)
	private Date recordTime;															//开单日期
	private String doctorName;													//医生签字
	
	private ColourDopplerUltrasound cdu;								//彩超
	private BloodBiochemical	bloodBiochemical;				//血生化
	private HardenArteries hardenArteries;								//动脉硬化
	
	private ToeBrachialIndex toaBrachialIndex;						//趾臂指数
	private UrineRoutineTest urineRoutineTest;						//尿常规
	private Cardiogram cardiogram;											//心电图
	private DynamicBloodPressureMonitor dbpm;				//动态血压监控
	public int getSheetId() {
		return sheetId;
	}
	public void setSheetId(int sheetId) {
		this.sheetId = sheetId;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getWaistline() {
		return waistline;
	}
	public void setWaistline(float waistline) {
		this.waistline = waistline;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public ColourDopplerUltrasound getCdu() {
		return cdu;
	}
	public void setCdu(ColourDopplerUltrasound cdu) {
		this.cdu = cdu;
	}
	public BloodBiochemical getBloodBiochemical() {
		return bloodBiochemical;
	}
	public void setBloodBiochemical(BloodBiochemical bloodBiochemical) {
		this.bloodBiochemical = bloodBiochemical;
	}
	public HardenArteries getHardenArteries() {
		return hardenArteries;
	}
	public void setHardenArteries(HardenArteries hardenArteries) {
		this.hardenArteries = hardenArteries;
	}
	public ToeBrachialIndex getToaBrachialIndex() {
		return toaBrachialIndex;
	}
	public void setToaBrachialIndex(ToeBrachialIndex toaBrachialIndex) {
		this.toaBrachialIndex = toaBrachialIndex;
	}
	public UrineRoutineTest getUrineRoutineTest() {
		return urineRoutineTest;
	}
	public void setUrineRoutineTest(UrineRoutineTest urineRoutineTest) {
		this.urineRoutineTest = urineRoutineTest;
	}
	public Cardiogram getCardiogram() {
		return cardiogram;
	}
	public void setCardiogram(Cardiogram cardiogram) {
		this.cardiogram = cardiogram;
	}
	public DynamicBloodPressureMonitor getDbpm() {
		return dbpm;
	}
	public void setDbpm(DynamicBloodPressureMonitor dbpm) {
		this.dbpm = dbpm;
	}
	
	
}
