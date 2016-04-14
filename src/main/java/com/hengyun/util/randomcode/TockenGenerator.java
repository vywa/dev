package com.hengyun.util.randomcode;

import com.hengyun.util.encrypt.MD5Util;

/*
 * 
 *  生成随机字符
 * */
public class TockenGenerator {

	public static String generate(String username){
		
			long time = System.currentTimeMillis();
			StringBuilder builder = new StringBuilder();
			String tocken = String.valueOf(time);
			builder.append(tocken).append(username);
			String password =builder.toString();
			return MD5Util.string2MD5(password);

       }  
	
	
}
