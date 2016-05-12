package com.hengyun.dao.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午8:50:03
* 参数不合法
*/
public class IlligalArgumentException extends DBException{

	public IlligalArgumentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public IlligalArgumentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
