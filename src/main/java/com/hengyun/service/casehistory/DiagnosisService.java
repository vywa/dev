package com.hengyun.service.casehistory;

import com.hengyun.domain.casehistory.Diagnosis;
import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午9:59:56
* 诊断结果业务类
*/
public interface DiagnosisService extends BaseService<Diagnosis,Integer>{

	/*
	 * 
	 *  自动计算危险等级
	 * 
	 * */
	public DangerLevel assess(int caseHistoryId);
	
	/*
	 *  存储危险等级
	 * 
	 * */
	public boolean storeDanger(Diagnosis diagnosis);
	
	/*
	 *  查询诊断结果
	 * */
	public Diagnosis query(int diagnosisId);
	
	
}
