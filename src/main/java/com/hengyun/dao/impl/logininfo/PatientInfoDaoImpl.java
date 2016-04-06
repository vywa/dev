package com.hengyun.dao.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.hengyun.dao.logininfo.PatientInfoDao;
import com.hengyun.domain.loginInfo.PatientInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:47:40
* 病人信息数据访问层
*/
@Repository
public class PatientInfoDaoImpl  implements PatientInfoDao{

	@Resource
	 private MongoTemplate mongoTemplate;

	@Override
	public void addPatient(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updatePatient(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PatientInfo queryOne(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientInfo> query(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
