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

import com.hengyun.dao.patient.BloodSuggerInfoDao;
import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.BloodSuggerInfoService;

public class BloodSuggerInfoServiceImpl extends BaseServiceImpl<BloodSuggerInfo,Integer> implements BloodSuggerInfoService{
	
	 private static final Logger log = LoggerFactory.getLogger(BloodSuggerInfoServiceImpl.class);
	 
	@Resource
	private BloodSuggerInfoDao bloodSuggerInfoDao;
	
	public List<BloodSuggerInfo> getInfoById(int userId) {
		// TODO Auto-generated method stub
		  Query query = new Query();
	        Criteria criteria = Criteria.where("userId").is(userId);
	        query.addCriteria(criteria);
		return bloodSuggerInfoDao.queryList(query);
	}


	public List<BloodSuggerInfo> getInfoByTime(long startTime, long endTime,int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = Criteria.where("measureTime").gt(startTime).lte(endTime).andOperator(Criteria.where("userId").is(userId));
	    
        query.addCriteria(criteria);
        query.with(new Sort(Direction.ASC, "measureTime"));
		return bloodSuggerInfoDao.queryList(query);
	}


	public List<BloodSuggerInfo> getlatestTime(int userId) {
		// TODO Auto-generated method stub
		Query  query = new Query();
	     Criteria criteria = Criteria.where("userId").is(userId);
			 
	      query.addCriteria(criteria).with(new Sort(Direction.DESC, "measureTime"));
			BloodSuggerInfo info =  bloodSuggerInfoDao.queryOne(query);
			if(info == null) {
				log.info("病人:  "+userId +"最近没有血糖测量数据");
				return null;
			}else {
			long time= info.getMeasureTime();
		
			Date date = new Date(time);
			log.info(MessageFormat.format("病人最近的血糖测量时间为: {0}", date.toLocaleString()));
			
			Calendar   calendar   =   new   GregorianCalendar(); 
		     calendar.setTime(date); 
		     calendar.add(Calendar.DATE,-1);
		     date=calendar.getTime();  
		     long startTime = date.getTime();
		
		     return getInfoByTime(startTime,time,userId);
			}
	}
}