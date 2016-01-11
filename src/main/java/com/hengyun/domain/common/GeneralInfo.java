package com.hengyun.domain.common;

import java.io.Serializable;
import java.util.Date;

/*
 *  用户个人基本信息
 * 
 * */
public class GeneralInfo implements Serializable{

	
/*
 *  基本资料
 * */
	
	private String userId;						//用户ID
	private String username;					//用户名
	private String gender;						//性别
	private int age;									//年龄
	private Date birthday;						//生日
	private String image;							//用户图像
	private String nation;						//民族
	private String hometown;				//出生地
	private String department;				//现住址
	
	
	private float height;							//身高
	private float weight;							//体重
	
	

	/*
	 *  联系方式
	 * */
	private String email;							//邮箱
	private String QQ;								//QQ
	private String mobilephone;			//手机号
	
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public GeneralInfo() {
		super();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
