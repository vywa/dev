package com.hengyun.util.date;

import java.text.SimpleDateFormat;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月19日 下午2:46:25
* 日期工具类
*/
public class DateUtil {

	/*
	 *  获取日期格式对象
	 * */
	private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {  
        return new SimpleDateFormat(parttern);  
    } 
	
	
}
