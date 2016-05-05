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
	
	private String username;						//用户名
	
	private String trueName;					//姓名
	private String sex;								//性别
	
	private String birthday;						//生日
	private String iconUrl;							//用户图像地址
	private String nation;						//民族
	private String hometown;				//出生地
	private String address;						//现住址
	private int age;									//用户年龄
	
	
	private String resume;						//简介
	
	private String height;							//身高
	private String weight;							//体重
	
	private String disease;						//患病（高血压，高血糖，高血脂）

	/*
	 *  联系方式
	 * */
	private String email;							//邮箱
	private String QQ;								//QQ
	private String mobilephone;			//手机号
	private String weiBo;
	private String weiChat;
	
	private String qqName;
	private String weiboName;
	private String weiChatName;
	
	
	
	
	
	private String recordTime;							//记录时间

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQqName() {
		return qqName;
	}
	public void setQqName(String qqName) {
		this.qqName = qqName;
	}
	public String getWeiboName() {
		return weiboName;
	}
	public void setWeiboName(String weiboName) {
		this.weiboName = weiboName;
	}
	public String getWeiChatName() {
		return weiChatName;
	}
	public void setWeiChatName(String weiChatName) {
		this.weiChatName = weiChatName;
	}
	public String getWeiBo() {
		return weiBo;
	}
	public void setWeiBo(String weiBo) {
		this.weiBo = weiBo;
	}
	public String getWeiChat() {
		return weiChat;
	}
	public void setWeiChat(String weiChat) {
		this.weiChat = weiChat;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
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
