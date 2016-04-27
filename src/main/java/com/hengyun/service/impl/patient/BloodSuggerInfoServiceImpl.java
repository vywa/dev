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

import com.alibaba.fastjson.JSON;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.patient.BloodSuggerInfoDao;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.domain.notice.Notice.noticeType;
import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.notice.MedicalNoticeService;
import com.hengyun.service.patient.BloodSuggerInfoService;

public class BloodSuggerInfoServiceImpl extends BaseServiceImpl<BloodSuggerInfo,Integer> implements BloodSuggerInfoService{
	
	 private static final Logger log = LoggerFactory.getLogger(BloodSuggerInfoServiceImpl.class);
	 
	@Resource
	private BloodSuggerInfoDao bloodSuggerInfoDao;
	
	@Resource
	private RosterService rosterService;
	
	@Resource
	private MedicalNoticeService medicalNoticeService;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	/*
	 *  添加血糖
	 * */
	@Override
	public void addInfo(BloodSuggerInfo bloodSuggerInfo, int userId) {
		// TODO Auto-generated method stub
		int measureId = indexCollectionDao.updateIndex("measureId");
		bloodSuggerInfo.setId(measureId);
		bloodSuggerInfo.setRecordTime(new Date());
	
		bloodSuggerInfoDao.save(bloodSuggerInfo);
		if(needAlarm(bloodSuggerInfo)){
			int doctorId = rosterService.getDoctor(String.valueOf(userId));
			MedicalNotice medicalNotice = new MedicalNotice();
			medicalNotice.setNoticeFromId(doctorId);
			//血糖危险
			medicalNotice.setNoticeType(3);
			medicalNotice.setNoticeToId(userId);
			medicalNotice.setType(noticeType.medical_notice);
			medicalNotice.setSendTime(new Date());
			medicalNotice.setContent("病人血糖危险");
			medicalNoticeService.addNotice(medicalNotice);
			String data=JSON.toJSON(medicalNotice).toString();
			/*
			try {
				HttpClientUtil.doGet(data);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			*/
		}
	}
	
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
			
			long measureTime= info.getMeasureTime();
			Date date = new Date(measureTime);
			
			
			log.info(MessageFormat.format("病人最近的血糖测量时间为: {0}", date.toLocaleString()));
			
			Calendar   calendar   =   new   GregorianCalendar(); 
		     calendar.setTime(date); 
		     calendar.add(Calendar.DATE,-1);
		     date=calendar.getTime();  
		     long startTime = date.getTime();
		
		     return getInfoByTime(startTime,measureTime,userId);
			}
	}


	/*
	 *  获取用户某个最近时间端的血糖记录
	 * 
	 * */
	@Override
	public List<BloodSuggerInfo> getlatestTime(int userId, int count, String type) {
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
		     if(type.equals("day")){
		     calendar.add(Calendar.DATE,-1);
		     } else if(type.equals("week")){
		    	 calendar.add(Calendar.WEEK_OF_YEAR,-1);
		     } else if(type.equals("month")){
		    	 calendar.add(Calendar.MONTH,-1);
		     }
		     date=calendar.getTime();  
		     long startTime = date.getTime();
		
		     return getInfoByTime(startTime,time,userId);
			}
		
	}

	/*
	 *  血糖是否需要报警
	 *  血糖连续两天高于某一值
	 * */
	@Override
	public boolean needAlarm(BloodSuggerInfo bloodSuggerInfo) {
		// TODO Auto-generated method stub
		if(bloodSuggerInfo.getBsValue()>30){
			return true;
		}
		return false;
	}

	/*
	 *  获取最近一天时间血糖，最近测量时间排前
	 * */
	@Override
	public List<BloodSuggerInfo> getlatestRecord(int userId) {
		// TODO Auto-generated method stub
		Query  query = new Query();
	     Criteria criteria = Criteria.where("userId").is(userId);
			 
	      query.addCriteria(criteria).with(new Sort(Direction.DESC, "measureTime"));
			BloodSuggerInfo info =  bloodSuggerInfoDao.queryOne(query);
			if(info == null) {
				log.info("病人:  "+userId +"最近没有血糖测量数据");
				return null;
			}else {
			
			long measureTime= info.getMeasureTime();
			Date date = new Date(measureTime);
			
			
			log.info(MessageFormat.format("病人最近的血糖测量时间为: {0}", date.toLocaleString()));
			
			Calendar   calendar   =   new   GregorianCalendar(); 
		     calendar.setTime(date); 
		     calendar.add(Calendar.DATE,-1);
		     date=calendar.getTime();  
		     long startTime = date.getTime();
		
		     return getOrderByTime(startTime,measureTime,userId);
			}
	}

	@Override
	public List<BloodSuggerInfo> getOrderByTime(long startTime, long endTime, int userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = Criteria.where("measureTime").gt(startTime).lte(endTime).andOperator(Criteria.where("userId").is(userId));
	    
        query.addCriteria(criteria).with(new Sort(Direction.DESC, "id"));
     
		return bloodSuggerInfoDao.queryList(query);
	}


	
}
