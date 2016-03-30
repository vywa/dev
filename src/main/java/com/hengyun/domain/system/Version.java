package com.hengyun.domain.system;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:46:37
* 版本
*/
public class Version implements Serializable{

	private int major;
	private int minor;
	private int modified;
	private String date;
	private String zimu;
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getModified() {
		return modified;
	}
	public void setModified(int modified) {
		this.modified = modified;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getZimu() {
		return zimu;
	}
	public void setZimu(String zimu) {
		this.zimu = zimu;
	}
	
	
}
