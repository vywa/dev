package com.hengyun.util.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:32:48
* 系统运行时异常基类
*/
public class ThealthRuntimeException extends RuntimeException{

	private int code;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public ThealthRuntimeException(int code) {
		super();
		this.code = code;
	}
	
	public ThealthRuntimeException(int code,String msg) {
		super(msg);
		this.code = code;
	}
	
	public ThealthRuntimeException(int code,String msg,Throwable cause) {
		super(msg,cause);
		this.code = code;
	}
	

	public ThealthRuntimeException(){
		super();
	}
	
	public ThealthRuntimeException (String msg){
		super(msg);
	}
	
	public ThealthRuntimeException(Throwable cause){
		super(cause);
	}
	
	public ThealthRuntimeException(String msg , Throwable cause){
		super(msg,cause);
	}
	
	
}
