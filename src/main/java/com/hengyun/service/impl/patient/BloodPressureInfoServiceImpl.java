package com.hengyun.service.impl.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.patient.BloodPressureInfoDao;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.BloodPressureInfoService;


public class BloodPressureInfoServiceImpl extends BaseServiceImpl<BloodPressureInfo,Integer> implements BloodPressureInfoService{

	@Resource
	private BloodPressureInfoDao bloodPressureInfoDao;
	
	
	public BloodPressureInfoDao getBloodPressureInfoDao() {
		return bloodPressureInfoDao;
	}


	public void setBloodPressureInfoDao(BloodPressureInfoDao bloodPressureInfoDao) {
		this.bloodPressureInfoDao = bloodPressureInfoDao;
	}


	public List<BloodPressureInfo> getInfoById(int userId) {
		// TODO Auto-generated method stub
		  Query query = new Query();
	        Criteria criteria = Criteria.where("userId").is(userId);
	        query.addCriteria(criteria);
		return bloodPressureInfoDao.queryList(query);
	}


	public List<BloodPressureInfo> getInfoByTime(long begin, long end,int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
        Criteria criteria = Criteria.where("measureTime").gt(begin).lte(end).andOperator(Criteria.where("userId").is(userId));
        query.addCriteria(criteria);
		return bloodPressureInfoDao.queryList(query);
	}

}
