package com.hengyun.service.casehistory;

import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;
import com.hengyun.domain.casehistory.RiskFactor;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午4:05:41
* 危险因素业务类
*/
public interface RiskFactorService extends BaseService<RiskFactor,Integer>{

	/*
	 *  危险因素添加
	 * */
	public boolean addFactor(RiskFactor riskFactor);
	
	/*
	 *  更新危险因素
	 * */
	public boolean updateFactor(RiskFactor riskFactor);
	
	/*
	 *  危险因素个数
	 * */
	public int DagerCount(RiskFactor riskFactor); 
	
	
}
