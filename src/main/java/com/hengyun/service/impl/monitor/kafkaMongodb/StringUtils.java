package com.hengyun.service.impl.monitor.kafkaMongodb;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月24日 下午5:38:58
* 字符串工具类
*/
public class StringUtils {

	public static<T> String join(Iterable<T> elements , String delim){
		StringBuilder result = new StringBuilder();
		boolean first = true;
		
		for(T elem : elements){
			if(first){
				first = false;
			} else {
				result.append(delim);
			}
			 result.append(elem);
		}
		return result.toString();
	}
}
