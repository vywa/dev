package com.hengyun.domain.patient;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月10日 上午10:21:36
* 类说明
*/
public class MachineBloodResponse {

	private int timestamp;
	private String magic;
	private String mac;
	private int code;
	private int len;
	private int return_code;
	private int opcode;
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int getReturn_code() {
		return return_code;
	}
	public void setReturn_code(int return_code) {
		this.return_code = return_code;
	}
	public int getOpcode() {
		return opcode;
	}
	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}
	
	


	
}
