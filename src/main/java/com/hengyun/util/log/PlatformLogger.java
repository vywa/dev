package com.hengyun.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.impl.Log4jLoggerAdapter;

import ch.qos.logback.classic.Level;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月22日 下午1:53:31
* 平台日志类
*/

public class PlatformLogger {

	
	final static String FQCN = Log4jLoggerAdapter.class .getName();
	
	
	public static final String BUISINESS_LOG ="buisiness";
	public static final String INFO_LOG = "info";
	
	private static final String DEBUG_LOG="debug";
	private static final String ERROR_LOG="error";
	
	private static final Logger buisiness = LoggerFactory.getLogger(PlatformLogger.class.getName());
	private static final Logger info = LoggerFactory.getLogger(PlatformLogger.class.getName());
	private static final Logger debug = LoggerFactory.getLogger(PlatformLogger.class.getName());
	private static final Logger error = LoggerFactory.getLogger(PlatformLogger.class.getName());
	
	private PlatformLogger(String loggerName){
		
	}
	
	public static PlatformLogger getLogger(String loggerName) {
		return new PlatformLogger(loggerName);
		}
	
	public static void buisiness(String msg){
		
		buisiness.info(msg);
	}
	
	public static void info(String msg){
		
		info.info(msg);
	}
	
	public static void debug(String msg){
		debug.debug(msg);
	}
	
	public static void error(String msg){
		error.error(msg);
	}
	
}
