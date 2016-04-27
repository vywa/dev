package com.hengyun.service.impl.patient;

import com.hengyun.domain.patient.HealthLine;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.HealthLineService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 下午2:07:40
* 类说明
*/
public class HealthLineServiceImpl extends BaseServiceImpl<HealthLine,Integer> implements HealthLineService{

	/*
	 *  获取血糖线
	 * */
	@Override
	public HealthLine getSuggerLine(int userId) {
		// TODO Auto-generated method stub
		HealthLine line = new HealthLine();
		return line;
	}

	/*
	 *  获取血压线
	 * */
	@Override
	public HealthLine getPressureLine(int userId) {
		// TODO Auto-generated method stub
		HealthLine line = new HealthLine();
		return line;
	}

}
