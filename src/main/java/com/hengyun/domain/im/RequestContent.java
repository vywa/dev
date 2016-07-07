package com.hengyun.domain.im;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午9:41:27
* 类说明
*/
public class RequestContent<T> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RequestContent(T data) {
		super();
		this.data = data;
	}

	public RequestContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
