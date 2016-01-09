package com.hengyun.util.randomcode;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
 *  生成随机字符
 * */
public class TockenGenerator {

	public static String generate(String username){
		char[] array={   
	               'Q', '@', '8', 'y', '%', '^', '5', 'Z', '(', 'G', '_', 'O', '`',  
	               'S', '-', 'N', '<', 'D', '{', '}', '[', ']', 'h', ';', 'W', '.',  
	               '/', '|', ':', '1', 'E', 'L', '4', '&', '6', '7', '#', '9', 'a',  
	               'A', 'b', 'B', '~', 'C', 'd', '>', 'e', '2', 'f', 'P', 'g', ')',  
	               '?', 'H', 'i', 'X', 'U', 'J', 'k', 'r', 'l', '3', 't', 'M', 'n',  
	               '=', 'o', '+', 'p', 'F', 'q', '!', 'K', 'R', 's', 'c', 'm', 'T',  
	               'v', 'j', 'u', 'V', 'w', ',', 'x', 'I', '$', 'Y', 'z', '*'  
	           };
			long time = System.currentTimeMillis();
			StringBuilder builder = new StringBuilder();
			String tocken = String.valueOf(time);
			builder.append(tocken).append(username);
			return builder.toString();
			
		
       }  
	
	
}
