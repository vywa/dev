package com.hengyun.service.patient;

import java.util.Date;
import java.util.List;

import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.BaseService;

public interface BloodPressureInfoService extends BaseService<BloodPressureInfo,Integer>{

	//查询某个用户的血压信息
	public List<BloodPressureInfo> getInfoById(int userId);
	
	//获取某个区段的信息
	public List<BloodPressureInfo> getInfoByTime(long startTime,long endTime ,int userId);

	
	//获取最近一天数据
	public List<BloodPressureInfo> getlatestTime(int userId) ;
}
