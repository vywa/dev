package com.hengyun.dao.exception;

import com.hengyun.util.exception.ThealthRuntimeException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月8日 上午11:07:06
* 数据库操作异常
*/
public class DBException extends ThealthRuntimeException {

	public DBException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public DBException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public DBException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public DBException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public DBException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public DBException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
