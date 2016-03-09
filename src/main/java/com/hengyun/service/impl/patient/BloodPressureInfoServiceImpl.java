package com.hengyun.service.impl.patient;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.patient.BloodPressureInfoDao;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.BloodPressureInfoService;


public class BloodPressureInfoServiceImpl extends BaseServiceImpl<BloodPressureInfo,Integer> implements BloodPressureInfoService{

	 private static final Logger log = LoggerFactory.getLogger(BloodPressureInfoServiceImpl.class);
	 
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

	public List<BloodPressureInfo> getlatestTime(int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = Criteria.where("userId").is(userId);
		 
        query.addCriteria(criteria).with(new Sort(Direction.DESC, "measureTime"));
		BloodPressureInfo info =  bloodPressureInfoDao.queryOne(query);
		if(info ==null){
			log.info("病人: "+userId+"最近没有血压测量数据");
			return null;
		} else{
		long time= info.getMeasureTime();
		Date date = new Date(time);
		log.info(MessageFormat.format("病人最近血压的测量时间为: {0}", date.toLocaleString()));
		Calendar   calendar   =   new   GregorianCalendar(); 
	     calendar.setTime(date); 
	     calendar.add(Calendar.DATE,-1);
	     date=calendar.getTime();  
	     long startTime = date.getTime();
	     return getInfoByTime(startTime,time,userId);
		}
	}

	public List<BloodPressureInfo> getInfoByTime(long begin, long end,int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = Criteria.where("measureTime").gt(begin).lte(end).andOperator(Criteria.where("userId").is(userId));
		 
        query.addCriteria(criteria).with(new Sort(Direction.ASC, "measureTime"));
		return bloodPressureInfoDao.queryList(query);
	}

	/*
	 *  某个时间前的血压记录
	 * 
	 * */
	@Override
	public List<BloodPressureInfo> getlatestTime(int userId, int day, String type) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = Criteria.where("userId").is(userId);
		 
        query.addCriteria(criteria).with(new Sort(Direction.DESC, "measureTime"));
		BloodPressureInfo info =  bloodPressureInfoDao.queryOne(query);
		if(info ==null){
			log.info("病人: "+userId+"最近没有血压测量数据");
			return null;
		} else{
		long time= info.getMeasureTime();
		Date date = new Date(time);
		log.info(MessageFormat.format("病人最近血压的测量时间为: {0}", date.toLocaleString()));
		Calendar   calendar   =   new   GregorianCalendar(); 
	     calendar.setTime(date); 
	     if(type.equals("day")){
	     calendar.add(Calendar.DATE,-1);
	     }else if(type.equals("week")){
	    	 calendar.add(Calendar.WEEK_OF_YEAR,-1);
	     }  else if(type.equals("month")){
	    	 calendar.add(Calendar.MONTH,-1);
	     }
	     date=calendar.getTime();  
	     long startTime = date.getTime();
	     return getInfoByTime(startTime,time,userId);
		}
		
	}

}
