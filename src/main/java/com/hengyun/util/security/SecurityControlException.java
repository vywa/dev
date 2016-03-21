package com.hengyun.util.security;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月21日 下午2:37:06
* 权限控制异常
*/
public class SecurityControlException extends RuntimeException{

	public  SecurityControlException(){}
	
	public SecurityControlException(String errMsg){
		super(errMsg);
	}
}
