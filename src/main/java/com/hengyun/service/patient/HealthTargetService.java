package com.hengyun.service.patient;

import com.hengyun.domain.patient.HealthTarget;
import com.hengyun.domain.patient.HealthTargetResponse;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午4:19:48
* 健康目标服务层
*/
public interface HealthTargetService extends BaseService<HealthTarget,Integer>{

	/*
	 * 
	 *  设置降压目标
	 * 
	 * */
	public boolean setBloodPressure(HealthTarget healthTarget);
	
	/*
	 * 
	 *  设置降糖目标
	 * 
	 * */
	public boolean setBloodSugger(HealthTarget healthTarget);
	
	/*
	 * 
	 *  获取病人血压目标记录
	 * 
	 * */
	public  HealthTargetResponse getBloodPressure(int patientId);
	
	/*
	 * 
	 *  获取病人血糖目标记录
	 * 
	 * */
	public HealthTargetResponse getBloodSugger(int patientId);
	
	
	
}
