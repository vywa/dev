package com.hengyun.domain.im;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午9:41:43
* 类说明
*/
public class ResponseResult<T> extends ResponseCode{

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseResult(T data) {
		super();
		this.data = data;
	}
	
	
	
}
