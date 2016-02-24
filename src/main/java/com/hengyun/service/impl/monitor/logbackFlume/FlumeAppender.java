package com.hengyun.service.impl.monitor.logbackFlume;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午5:06:07
* logback flume连接类
*/
public class FlumeAppender extends UnsynchronizedAppenderBase<ILoggingEvent>{

	private FlumeEventWriter eventWriter = new FlumeEventWriter(this);
	private PatternLayout layout;
	private String host;
	private int port;
	
	
	
	
	@Override
	protected void append(ILoggingEvent eventObject) {
		// TODO Auto-generated method stub
		if(!isStarted()){
			return ;
		}
		
	}

	
}
