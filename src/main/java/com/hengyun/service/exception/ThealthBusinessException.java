package com.hengyun.service.exception;

import com.hengyun.util.exception.ThealthRuntimeException;

/*
 *  基本业务类异常
 * 
 * */
public class ThealthBusinessException extends ThealthRuntimeException{

	public ThealthBusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public ThealthBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}