package com.hengyun.util.randomcode;

import com.hengyun.util.encrypt.MD5Util;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午5:11:49
* 加密密码
*/
public class EncryptPassword {
	
	//md5加密
	public static String encode(String username){

		StringBuilder builder = new StringBuilder();
		String password = String.valueOf(username);
		String salt = "2016Hy!9";
		builder.append(password).append(salt);
		password  =builder.toString();
		return MD5Util.string2MD5(password);
   }  
	

}
