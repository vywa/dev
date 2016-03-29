package com.hengyun.domain.hospital;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.hengyun.domain.location.Location;

/*
 *  医院信息
 * 
 * 

 * */
public class Hospital implements Serializable{

	
	private int id;																//医院ID
	
	private String hospitalName;									//医院名称
	private String shortName;										//医院简称
	private String address;												//医院地址
	private String level;														//级别
	private List<Integer> OfficeList;							//医院科室列表
	private String telephone;											//医院电话
	private String email;													//医院邮件
	private String hospitalIM;										//医院即时通讯号
	private String weiChatNumber;				//医院公众号

	private Location	location;										//医院坐标
	
	

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public List<Integer> getOfficeList() {
		return OfficeList;
	}
	public void setOfficeList(List<Integer> officeList) {
		OfficeList = officeList;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHospitalIM() {
		return hospitalIM;
	}
	public void setHospitalIM(String hospitalIM) {
		this.hospitalIM = hospitalIM;
	}
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getWeiChatNumber() {
		return weiChatNumber;
	}
	public void setWeiChatNumber(String weiChatNumber) {
		this.weiChatNumber = weiChatNumber;
	}
	
	
}
