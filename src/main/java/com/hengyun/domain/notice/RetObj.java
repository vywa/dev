package com.hengyun.domain.notice;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 下午3:11:10
* 类说明
*/
public class RetObj {

	private boolean flag = true;
	private String msg;
	private Object obj;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public RetObj() {

	}
	public RetObj(boolean flag, String msg, Object obj) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}
	public RetObj(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}
}
