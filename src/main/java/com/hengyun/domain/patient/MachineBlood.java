package com.hengyun.domain.patient;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月10日 下午3:53:19
* 类说明
*/
public class MachineBlood implements Serializable{

	private String magic;
	private int len;
	private String mac;
	private int opcode;
	private int code;
	private int device_user;
	private String at;
	private int timestamp;
	private int sys;				//高压
	private int dia;					//低压
	
	private int pulse;				//心率
	
	
	private int arrhythmia;



	

	public int getSys() {
		return sys;
	}
	public void setSys(int sys) {
		this.sys = sys;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public int getArrhythmia() {
		return arrhythmia;
	}
	public void setArrhythmia(int arrhythmia) {
		this.arrhythmia = arrhythmia;
	}
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getOpcode() {
		return opcode;
	}
	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getDevice_user() {
		return device_user;
	}
	public void setDevice_user(int device_user) {
		this.device_user = device_user;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
