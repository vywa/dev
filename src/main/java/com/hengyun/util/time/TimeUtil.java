package com.hengyun.util.time;

import java.util.Calendar;

//时间工具类
public class TimeUtil {

	private static  Calendar cal = Calendar.getInstance();
	public static Calendar getCalendar(){
		return  cal;
	}
	
	public static Calendar getyearstday(){
		 cal.add(Calendar.DAY_OF_MONTH, -1);
		 return cal;
	}
	
	public static Calendar gettomoror(){
		 cal.add(Calendar.DAY_OF_MONTH, 1);
		 return cal;
	}
}
