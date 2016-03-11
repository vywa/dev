package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.DoctorAdvice;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午3:23:01
* 医嘱业务类
*/
public interface DoctorAdviceService extends BaseService<DoctorAdvice,Integer>{

	/*
	 * 	添加医嘱
	 * */
	public boolean addAdvice(DoctorAdvice doctorAdvice);
	
	/*
	 *  修改医嘱
	 * */
	public boolean updateAdvice(DoctorAdvice doctorAdvice);
	
	/*
	 *  查看医嘱
	 * */
	public DoctorAdvice queryAdvice(int doctorAdviceId);
	
	/*
	 *  查询病历所有医嘱
	 * */
	public List<DoctorAdvice> queryAdviceList(int caseHistoryId);
	
	
}
