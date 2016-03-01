package com.hengyun.util.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:18:05
* 系统架构描述
*/
public class Architecture {

	private static final Logger log = LoggerFactory.getLogger(Architecture.class);
	
	
	private final static String APP_NAME="app.hengyun.name";
	private final static String APP_LANGUAGE="app.language.type";
	private final static String APP_CONTAINER="app.container.type";
	private final static String APP_DATASOURCE="app.datasource.type";
	private final static String APP_CACHE="app.cache.type";
	private final static String APP_MVC="app.mvc.architecture";
	private final static String APP_MESSAGE="app.message.component";
	
	public final static String APP_OTHRE_COMPONENT= "app.associate.components";
	
	static{
		/*
		APP_LANGUAGE="language";
		APP_CONTAINER="tomcat";
		APP_DATASOURCE="mongodb";
		APP_CACHE="redis";
		APP_MVC="springMVC";
		APP_MESSAGE="activemq";
		APP_OTHRE_COMPONENT="openfire";
		*/
	}
	
	public static String getInfomation(){
		return null; 
	}
}
