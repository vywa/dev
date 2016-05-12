package com.hengyun.dao.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午8:48:17
* 数据库操作超时
*/
public class OperationTimeoutException extends DBException{

	public OperationTimeoutException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public OperationTimeoutException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
