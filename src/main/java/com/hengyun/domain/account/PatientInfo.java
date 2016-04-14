package com.hengyun.domain.account;

import java.io.Serializable;
import java.util.List;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午1:59:00
* 病人信息
*/
public class PatientInfo implements Serializable{

	//账号信息
	private int 								patientId;							//用户ID
	private String 							username;							//用户名
	private String 							mobilephone;					//用户手机号
	private String 							email;									//用户邮箱

	private String 							QQ;										//QQ
	private String							weiChat;								//weiChat
	private String							weiBo;									//weiBo
	
	private String							password;							//用户密码
	private String 							encrptPassword;				//加密密码
	private int 								status;									//账号状态（0正常，-1删除，１异常，２冻结）
	
	//病人信息
	private String 							trueName;							//姓名
	private String 							sex;										//性别
	
	private String							birthday;								//生日
	private String 							iconUrl;									//用户图像地址
	private String 							nation;									//民族
	
	private String							address;								//现住址
	private int 								age;										//用户年龄
	
	private String 							height;									//身高
	private String 							weight;									//体重
	
	private List<Integer>				friendList;							//亲情号码
	
	//疾病管理
	private String 							disease;								//患病（１１１高血压，高血糖，高血脂）

	
	private String							recordTime;						//记录时间

	
	
	public List<Integer> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Integer> friendList) {
		this.friendList = friendList;
	}

	public String getEncrptPassword() {
		return encrptPassword;
	}

	public void setEncrptPassword(String encrptPassword) {
		this.encrptPassword = encrptPassword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getWeiChat() {
		return weiChat;
	}

	public void setWeiChat(String weiChat) {
		this.weiChat = weiChat;
	}

	public String getWeiBo() {
		return weiBo;
	}

	public void setWeiBo(String weiBo) {
		this.weiBo = weiBo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
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

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
