package com.hengyun.dao.impl.health;

import com.hengyun.dao.health.MedicalRecordDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.health.MedicalRecord;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 上午9:37:56
* 病历类数据操作实现类
*/
public class MedicalRecordDaoImpl  extends BaseMongodbDaoImpl<MedicalRecord,Integer> implements MedicalRecordDao{

	@Override
	protected Class<MedicalRecord> getEntityClass() {
		// TODO Auto-generated method stub
		return MedicalRecord.class;
	}

}
