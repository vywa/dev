package com.hengyun.dao.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午9:40:46
* 没有权限访问异常
*/
public class AuthorityDenyException extends DBException{

	public AuthorityDenyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public AuthorityDenyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
