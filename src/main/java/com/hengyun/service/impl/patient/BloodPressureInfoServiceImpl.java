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
import com.hengyun.dao.patient.BloodPressureInfoDao;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.domain.notice.Notice.noticeType;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.impl.notice.util.HttpClientUtil;
import com.hengyun.service.notice.MedicalNoticeService;
import com.hengyun.service.patient.BloodPressureInfoService;


public class BloodPressureInfoServiceImpl extends BaseServiceImpl<BloodPressureInfo,Integer> implements BloodPressureInfoService{

	 private static final Logger log = LoggerFactory.getLogger(BloodPressureInfoServiceImpl.class);
	 
	@Resource
	private BloodPressureInfoDao bloodPressureInfoDao;
	
	@Resource
	private RosterService rosterService;
	
	@Resource
	private MedicalNoticeService medicalNoticeService;
	
	/*
	 * 
	 *  	添加血压数据
	 *  
	 * */
	@Override
	public void addInfo(BloodPressureInfo bloodPressureInfo) {
		// TODO Auto-generated method stub
		//添加血压记录
		bloodPressureInfoDao.save(bloodPressureInfo);
		
		if(needAlarm(bloodPressureInfo)){
			int doctorId = rosterService.getDoctor(String.valueOf(bloodPressureInfo.getUserId()));
			MedicalNotice medicalNotice = new MedicalNotice();
			medicalNotice.setNoticeFromId(doctorId);
			medicalNotice.setNoticeToId(bloodPressureInfo.getUserId());
			//高压危险
			medicalNotice.setNoticeType(2);
			medicalNotice.setType(noticeType.medical_notice);
			medicalNotice.setSendTime(new Date());
			medicalNotice.setContent("病人高压危险");
			medicalNoticeService.addNotice(medicalNotice);
			
			//向医生推送病人危险信息
			String data=JSON.toJSON(medicalNotice).toString();
			try {
				HttpClientUtil.doGet(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 *  
	 * */
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

	/*
	 *  血压是否需要报警
	 *  连续两天血压高于一定值
	 * */
	@Override
	public boolean needAlarm(BloodPressureInfo bloodPressureInfo) {
		// TODO Auto-generated method stub
		boolean alarm = false;
		int highBP = bloodPressureInfo.getHighBP();
		int lowBP = bloodPressureInfo.getLowBP();
		if(highBP>180){
			alarm = true;
		} else if(lowBP>120){
			alarm = true;
		} 
		return alarm;
	}


	/*
	 *  获取用户血压等级
	 * */
	@Override
	public int getLevel(int userId) {
		// TODO Auto-generated method stub
		int level = 0;
		//获取最近测量的数据的血压数据
		List<BloodPressureInfo> blist = this.getlatestTime(userId);
		int highBP = 0;
		int lowBP = 0;
		int highTemp=0;
		int lowTemp=0;
		for(BloodPressureInfo temp :blist){
			lowTemp = temp.getLowBP();
			highTemp=temp.getHighBP();
			if(highBP<highTemp){
				highBP=highTemp;
			} 
			if(lowBP>lowTemp){
				lowBP= lowTemp;
			}
		}
		int temp =0;
		//评估低压
		if(lowBP>=90&&lowBP<100){
			temp =1;
		} else if(lowBP>=100&&lowBP<110){
			temp = 2;
		} else if(lowBP>=110){
			temp=3;
		} 
		//评估高压
		 if(highBP>=140&&highBP<160){
			if(temp<=1)
			temp=1;
		}else if(highBP>=160&&highBP<180){
			if(temp<=2)
			temp = 2;
		} else if(highBP>=180){
			if(temp<=3)
			temp=3;
		}
		return temp;
	}


	

}
