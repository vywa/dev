package com.hengyun.service.health;

import java.util.List;

import com.hengyun.domain.health.MedicalRecord;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 上午10:50:22
* 类说明
*/
public interface MedicalRecordService extends BaseService<MedicalRecord,Integer>{

	
	//添加病历记录
	public void addRecord(MedicalRecord medicalRecord);
	
	//查询病历记录
	public List<MedicalRecord> queryList(int patientId);
	
	
}
