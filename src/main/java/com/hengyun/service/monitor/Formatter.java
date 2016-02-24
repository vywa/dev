package com.hengyun.service.monitor;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午2:53:32
* 格式化接口
*/
public interface Formatter {

	String format(ILoggingEvent event);
}
