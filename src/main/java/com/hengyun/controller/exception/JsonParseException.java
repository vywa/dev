package com.hengyun.controller.exception;



/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月25日 下午3:06:39
* json解析错误
*/
public class JsonParseException extends ControllerException{

	public JsonParseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public JsonParseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
