package com.hengyun.util.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 下午6:34:44
* 验证码登陆tocken
*/
public class CodeUsernamePasswordTocken extends UsernamePasswordToken{

	//验证码
	private String conformCode;
	
	public CodeUsernamePasswordTocken(String username,char[] password,boolean rememberMe,String host,String code){
		super(username,password,rememberMe,host);
		this.conformCode = code;
	}
	
	public String getConformCode() {
		return conformCode;
	}

	public void setConformCode(String conformCode) {
		this.conformCode = conformCode;
	}
	
	
}
