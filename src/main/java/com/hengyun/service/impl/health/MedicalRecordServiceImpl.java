package com.hengyun.service.impl.health;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.health.MedicalRecordDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.health.MedicalRecord;
import com.hengyun.service.health.MedicalRecordService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 上午10:50:40
* 类说明
*/
public class MedicalRecordServiceImpl extends BaseServiceImpl<MedicalRecord,Integer> implements MedicalRecordService{

	private static final Logger log = LoggerFactory.getLogger(MedicalRecordServiceImpl.class);
	
	@Resource
	private MedicalRecordDao medicalRecordDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  添加病历记录
	 * */
	@Override
	public void addRecord(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("medicalRecordId");
		medicalRecord.setId(id);
		medicalRecordDao.save(medicalRecord);
	}

	/*
	 *  查询病历记录
	 * */
	@Override
	public List<MedicalRecord> queryList(int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientId));
		List<MedicalRecord> list = medicalRecordDao.queryList(query);
		return list;
	}

}
