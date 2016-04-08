package com.hengyun.dao.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.PatientInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:41:43
* 病人信息数据访问接口
*/
public interface PatientInfoDao {

	//添加病人信息
	public void addPatient(PatientInfo patientInfo) ;
	
	//更新病人信息
	public boolean updatePatient(PatientInfo patientInfo);
	
	//查询病人信息
	public PatientInfo queryOne(PatientInfo patientInfo);
	
	//查询病人列表
	public List<PatientInfo> query(PatientInfo patientInfo);
}
