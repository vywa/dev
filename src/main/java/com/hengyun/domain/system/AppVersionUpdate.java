package com.hengyun.domain.system;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午4:52:21
* app版本更新
*/
public class AppVersionUpdate implements Serializable{

	private int id;													//更新版本id
	private String appName;								//app名称
	private String type;										//apk类型

	private String serverCode;							//最新的apk版本
	private String apkUrl;									//下载apk地址
	private String description;							//描述信息
	private Date date;											//更新时间
		

	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getServerCode() {
		return serverCode;
	}
	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}
	public String getApkUrl() {
		return apkUrl;
	}
	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
