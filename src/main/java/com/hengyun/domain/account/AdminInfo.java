package com.hengyun.domain.account;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午1:44:34
*管理员账号
*/
public class AdminInfo implements Serializable{

	private int 								adminId;								//用户ID
	private String 							username;							//用户名
	private String 							mobilephone;					//用户手机号
	private String 							email;									//用户邮箱
	
	private String							password;							//用户密码
	private String							encryptPassword;			//加密密码
	private int 								level;										//管理员等级（１超级管理员，１普通管理员）
	private int 								status;									//管理员状态（０正常，－１删除，1异常，2冻结）
	
	private Date								recordTime;						//修改时间
	

	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptPassword() {
		return encryptPassword;
	}
	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
