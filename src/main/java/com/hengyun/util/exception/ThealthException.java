package com.hengyun.util.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:33:30
* 系统检查异常基类
*/
public class ThealthException extends Exception{

	public ThealthException(){
		super();
	}
	
	public ThealthException(String message){
		super(message);
	}
	
	public ThealthException(Throwable cause){
		super(cause);
	}
	
	public ThealthException(String message, Throwable cause){
		super(message,cause);
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	
	
}
