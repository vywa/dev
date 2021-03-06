package com.hengyun.service.impl.monitor;

import com.hengyun.service.monitor.Formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午2:55:37
* json类型格式
*/
public class JsonFormatter implements Formatter {

	private static final String QUOTE = "\'";
	private static final String COLON = ":";
	private static final String COMMA=",";
	
	private boolean expectJson = false;
	
	@Override
	public String format(ILoggingEvent event) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		fieldName("level",sb);
		quote(event.getLevel().levelStr,sb);
		sb.append(COMMA);
		fieldName("logger",sb);
		quote(event.getLoggerName(),sb);
		sb.append(COMMA);
		fieldName("timestamp",sb);
		sb.append(event.getTimeStamp());
		sb.append(COMMA);
		fieldName("message",sb);
		if(this.expectJson){
			sb.append(event.getFormattedMessage());
		} else {
			quote(event.getFormattedMessage(),sb);
		}
		sb.append("}");
		return sb.toString();
	}

	
	private static void fieldName(String name,StringBuilder sb){
		quote(name,sb);
		sb.append(COLON);
	}
	
	private static void quote(String value,StringBuilder sb){
		sb.append(QUOTE);
		sb.append(value);
		sb.append(QUOTE);
		
		
	}


	public boolean isExpectJson() {
		return expectJson;
	}


	public void setExpectJson(boolean expectJson) {
		this.expectJson = expectJson;
	}
	
	
}
