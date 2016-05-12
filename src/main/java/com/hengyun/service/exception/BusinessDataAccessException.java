package com.hengyun.service.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午9:48:04
* 访问数据层异常
*/
public class BusinessDataAccessException extends ThealthBusinessException{

	public BusinessDataAccessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public BusinessDataAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
