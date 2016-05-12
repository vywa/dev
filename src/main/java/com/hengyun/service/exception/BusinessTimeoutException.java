package com.hengyun.service.exception;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:43:52
* 业务访问超时异常
*/
public class BusinessTimeoutException extends ThealthBusinessException{

	public BusinessTimeoutException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public BusinessTimeoutException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
