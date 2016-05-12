package com.hengyun.dao.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午9:08:53
* 参数空指针
*/
public class NullArgumentException extends DBException{

	public NullArgumentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public NullArgumentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
