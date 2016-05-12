package com.hengyun.controller.exception;

import com.hengyun.util.exception.ThealthRuntimeException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月29日 上午10:02:13
* 控制层基类异常
*/
public class ControllerException extends ThealthRuntimeException{

	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ControllerException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
