package com.hengyun.service.patient;

import java.util.List;

import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.service.BaseService;

public interface BloodSuggerInfoService extends BaseService<BloodSuggerInfo,Integer>{

	/*
	 * 查询某个用户的血糖信息
	 * 
	 * */
		public List<BloodSuggerInfo> getInfoById(int userId);
		
		/*
		 * 获取某个区段的信息
		 * 
		 * */
		public List<BloodSuggerInfo> getInfoByTime(long startTime,long endTime,int userId);
		
		/*
		 * 获取最近一天数据
		 * 
		 * */
		public List<BloodSuggerInfo> getlatestTime(int userId) ;
		
		/*
		 *  获取用户最近某个时期的血糖数据
		 * 
		 * */
		public List<BloodSuggerInfo> getlatestTime(int userId,int count,String type) ;
}
