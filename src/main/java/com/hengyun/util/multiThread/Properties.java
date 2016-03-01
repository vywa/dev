package com.hengyun.util.multiThread;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;



/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 上午11:47:57
* 属性类
*/
public class Properties {

	Map<String,Object> property = new HashMap<String,Object>();
	private static ThreadLocal<String> name = new ThreadLocal<String>();
	
	public void setProperty(String key,Object value){
		Thread thread = new Thread();
		
	}
	
	public static Properties loadConfig(){
		Properties properties = new Properties();
		
		return properties;
	}
	
	public static void load(Properties properties , ClassLoader classLoad) throws IOException{
		if(classLoad == null){
			return ;
		}
		
	}
}
