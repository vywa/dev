package com.hengyun.util.date;

import java.util.Calendar;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 上午10:32:12
* 时间工具类
*/
public class TimeUtil {

	/*
	 * 当前时间以后
	 * 
	 * */
	
	public static long computeStartOfNextSecond(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.SECOND, 1);
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfNextMinute(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.MINUTE,1);
		return calendar.getTime().getTime();
		
	}
	
	public static long computeStartOfNextHour(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.add(Calendar.HOUR, 1);
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfNextDay(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfNextWeek(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		return calendar.getTime().getTime();

		
	}
	
	public static long computeStartOfNextMonth(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.MONTH, 1);
		return calendar.getTime().getTime();
	}
	
	/*
	 * 当前时间以前
	 * */
	
	public static long computeStartOfPrevioustSecond(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfPrevioustMinute(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.MINUTE, -1);
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfPrevioustHour(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.add(Calendar.HOUR_OF_DAY,-1);
		return calendar.getTime().getTime();
		
	}
	
	public static long computeStartOfPrevioustDate(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime().getTime();
	}
	
	//某时间前几天
	public static long computeStartOfPrevioustDate(long now,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.DAY_OF_YEAR, -1*day);
		return calendar.getTime().getTime();
	}
	
	
	public static long computeStartOfPrevioustWeek(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		return calendar.getTime().getTime();
	}
	
	//某时间前几周
	public static long computeStartOfPrevioustWeek(long now,int week){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(now));
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.add(Calendar.WEEK_OF_YEAR, -1*week);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
		return calendar.getTime().getTime();
	}
	
	public static long computeStartOfPrevioustMonth(long now){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.DATE,1);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime().getTime();
	}
	
	//某时间前几个月
	public static long computeStartOfPrevioustMonth(long now,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.DATE,1);
		calendar.add(Calendar.MONTH, -1*month);
		return calendar.getTime().getTime();
	}
	
	
	
}
