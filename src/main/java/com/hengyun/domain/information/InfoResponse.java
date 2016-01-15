package com.hengyun.domain.information;

import java.io.Serializable;

/*
 * 
 *  信息返回
 * */
public class InfoResponse implements Serializable{

	private String code;
	private Information info;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Information getInfo() {
		return info;
	}
	public void setInfo(Information info) {
		this.info = info;
	}
	
	
}
