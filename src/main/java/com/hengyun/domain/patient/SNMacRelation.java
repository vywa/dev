package com.hengyun.domain.patient;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月13日 上午9:24:28
* 类说明
*/
public class SNMacRelation implements Serializable{

	private String sn;
	private String mac;
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
}
