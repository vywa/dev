package com.hengyun.util.exception;


/*
 *  业务异常类
 * 
 * */
public class BusinessException extends RuntimeException
{
	
	private static final long serialVersionUID = -4641659455971522864L;
	private int code;
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public BusinessException(Throwable throwable)
	{
		super(throwable);
	}

	
	public BusinessException(String message,Throwable throwable)
	{
		super(message,throwable);
	}

	public BusinessException(int code,Throwable throwable) {
		super(throwable);
		this.code = code;
	}
	
	public BusinessException(int code,String message,Throwable throwable) {
		super(message,throwable);
		this.code = code;
	}

	
}