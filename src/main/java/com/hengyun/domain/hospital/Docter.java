package com.hengyun.domain.hospital;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

//医生信息
public class Docter implements Serializable{

	
	private String workNum;			//工号（医院id4位+科室id2位＋医生id３位+效验码1）
	private String name;
	private String level;						//医生职称
	private int hospitalId;				//所属医院id
	private String shortName;		//简称
	private String image;					//图像
	private String resume;				//简历
	private String sex;						//性别
	private int age;							//年龄
	private int userId;						//医生id
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
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
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}
