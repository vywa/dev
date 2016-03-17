package com.hengyun.service.patient;

import java.util.List;


import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.service.BaseService;

public interface BloodSuggerInfoService extends BaseService<BloodSuggerInfo,Integer>{

	/*
	 * 
	 *  添加血糖记录
	 * */
	public void addInfo(BloodSuggerInfo bloodSuggerInfo,int userId);
	
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
		
		/*
		 *  血糖是否需要处理
		 * */
		public boolean needAlarm(BloodSuggerInfo bloodSuggerInfo);
}
