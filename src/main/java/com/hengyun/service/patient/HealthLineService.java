package com.hengyun.service.patient;

import com.hengyun.domain.patient.HealthLine;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 下午2:06:33
* 健康参考线
*/
public interface HealthLineService extends BaseService<HealthLine,Integer>{

	public HealthLine getSuggerLine(int userId);
	
	public HealthLine getPressureLine(int userId);
}
