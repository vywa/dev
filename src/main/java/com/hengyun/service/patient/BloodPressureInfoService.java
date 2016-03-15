package com.hengyun.service.patient;

import java.util.List;

import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.BaseService;
/*
 * 	血压信息业务类
 * 
 * */
public interface BloodPressureInfoService extends BaseService<BloodPressureInfo,Integer>{

	/*
	 * 查询某个用户的血压信息
	 * 
	 * */
	public List<BloodPressureInfo> getInfoById(int userId);
	
	/*
	 * 获取用户某个时间区段的信息
	 * 
	 * */
	public List<BloodPressureInfo> getInfoByTime(long startTime,long endTime ,int userId);

	
	/*
	 * 获取最近一天数据
	 * 
	 * */
	public List<BloodPressureInfo> getlatestTime(int userId) ;
	
	/*
	 *  查询用户最近某个时间单位(天，日，月)的血压记录
	 * */
	public List<BloodPressureInfo> getlatestTime(int userId,int day,String type) ;
	
	/*
	 *  是否异常，需要处理
	 * */
	public boolean needAlarm(BloodPressureInfo bloodPressureInfo);
	
}
