package com.hengyun.service.patient;

import com.hengyun.domain.casehistory.HabitInfo;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午4:08:11
* 健康习惯业务接口
*/
public interface HabitInfoService extends BaseService<HabitInfo,Integer>{

	/*
	 *  存储健康习惯
	 * */
	public void storeHabit(HabitInfo habitInfo);
	
	/*
	 *  查询某个人的健康数据
	 * */
	public HabitInfo query(int userId);
	
	/*
	 *  修改某个用户的健康数据
	 * */
	public void update(HabitInfo habitInfo);
}
