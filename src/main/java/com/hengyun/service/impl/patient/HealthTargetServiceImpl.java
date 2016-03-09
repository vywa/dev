package com.hengyun.service.impl.patient;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.patient.HealthTargetDao;
import com.hengyun.domain.patient.HealthTarget;
import com.hengyun.domain.patient.HealthTargetResponse;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.HealthTargetService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午4:30:08
* 设置健康目标业务类
*/
public class HealthTargetServiceImpl extends BaseServiceImpl<HealthTarget,Integer> implements HealthTargetService{

	private static final Logger log = LoggerFactory.getLogger(HealthTargetServiceImpl.class);
	@Resource
	private HealthTargetDao healthTargetDao;
	/*
	 * 
	 *  设置病人降压目标
	 * 
	 * */
	@Override
	public boolean setBloodPressure(HealthTarget healthTarget) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(healthTarget.getPatientId()));
		Update update = Update.update("targetHighBloodPressure", healthTarget.getTargetHighBloodPressure()).
				addToSet("targetLowBloodPressure", healthTarget.getTargetLowBloodPressure());
		healthTargetDao.updateInser(query, update);
		return true;
	}

	/*
	 * 
	 *  设置病人降糖目标
	 * 
	 * */
	@Override
	public boolean setBloodSugger(HealthTarget healthTarget) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(healthTarget.getPatientId()));
		Update update = Update.update("zero", healthTarget.getZero()).
				addToSet("beforeBreakfast", healthTarget.getBeforeBreakfast()).addToSet("afterBreakfast", healthTarget.getAfterBreakfast()).
				addToSet("beforeLunch",healthTarget.getBeforeLunch()).addToSet("afterLunch", healthTarget.getAfterLunch()).
				addToSet("beforeSupper", healthTarget.getBeforeSupper()).addToSet("afterSupper", healthTarget.getAfterSupper()).
				addToSet("beforeSleep", healthTarget.getBeforeSleep()).addToSet("random", healthTarget.getRandom());
		healthTargetDao.updateInser(query, update);
		return true;
	}

	/*
	 * 
	 *  查询降压目标
	 * 
	 * */
	@Override
	public HealthTargetResponse getBloodPressure(int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientId));
		HealthTarget healthTarget = healthTargetDao.queryOne(query);
		if(healthTarget == null){
			return null;
		}
		HealthTargetResponse response = new HealthTargetResponse();
		response.setTargetLowBloodPressure(healthTarget.getTargetLowBloodPressure());
		response.setTargetHighBloodPressure(healthTarget.getTargetHighBloodPressure());
		response.setPatientId(patientId);
		return response;
	}

	/*
	 * 
	 *  查询降糖目标
	 * 
	 * */
	@Override
	public HealthTargetResponse getBloodSugger(int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientId));
		HealthTarget healthTarget = healthTargetDao.queryOne(query);
		if(healthTarget == null){
			return null;
		}
		HealthTargetResponse response = new HealthTargetResponse();
		response.setAfterBreakfast(healthTarget.getAfterBreakfast());
		response.setAfterLunch(healthTarget.getAfterLunch());
		response.setAfterSupper(healthTarget.getAfterSupper());
		response.setBeforeBreakfast(healthTarget.getBeforeBreakfast());
		response.setBeforeLunch(healthTarget.getBeforeLunch());
		response.setBeforeSleep(healthTarget.getBeforeSleep());
		response.setBeforeSupper(healthTarget.getBeforeSupper());
		response.setRandom(healthTarget.getRandom());
		response.setZero(healthTarget.getZero());
		response.setPatientId(patientId);
		return response;
		
	}

}
