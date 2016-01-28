package com.hengyun.domain.information;

import java.io.Serializable;

/*
 *  用户个人基本信息
 * 
 * */
public class Information implements Serializable{

	
/*
 *  基本资料
 * */
	
	private int userId;								//用户ID
	private String trueName;					//姓名
	private String sex;						//性别
	
	private String birthday;						//生日
	private String iconUrl;							//用户图像地址
	private String nation;						//民族
	private String hometown;				//出生地
	private String address;				//现住址
	
	
	private String height;							//身高
	private String weight;							//体重
	
	

	/*
	 *  联系方式
	 * */
	private String email;							//邮箱
	private String QQ;								//QQ
	private String mobilephone;			//手机号
	
	private String recordTime;							//记录时间
	
	
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
	
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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
	public Information() {
		super();
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
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
