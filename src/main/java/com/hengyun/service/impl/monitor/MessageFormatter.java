package com.hengyun.service.impl.monitor;

import com.hengyun.service.monitor.Formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午3:07:09
* 消息格式化类
*/
public class MessageFormatter implements Formatter {

	@Override
	public String format(ILoggingEvent event) {
		// TODO Auto-generated method stub
		return event.getFormattedMessage();
	}

}
