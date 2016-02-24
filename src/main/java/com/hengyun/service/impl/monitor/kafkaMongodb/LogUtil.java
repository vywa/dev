package com.hengyun.service.impl.monitor.kafkaMongodb;

import java.util.Map;

import org.slf4j.Logger;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午5:33:21
* 日志工具类
*/
public class LogUtil {

	public static void dumpConfiguration(Map<String,String> map,Logger log){
		log.trace("Starting connector with configuration: ");
		for(Map.Entry entry : map.entrySet()){
			log.trace("{}:{}",entry.getKey(),entry.getValue());
		}
	}
}
