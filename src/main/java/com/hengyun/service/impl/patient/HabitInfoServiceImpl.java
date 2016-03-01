package com.hengyun.service.impl.patient;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.patient.HabitInfoDao;
import com.hengyun.domain.patient.HabitInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.HabitInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午4:09:36
* 健康习惯业务实现类
*/
public class HabitInfoServiceImpl extends BaseServiceImpl<HabitInfo,Integer> implements HabitInfoService{

	private static final Logger log = LoggerFactory.getLogger(HabitInfoServiceImpl.class);
	
	@Resource
	private HabitInfoDao habitInfoDao;

	/*
	 *  添加用户健康数据
	 * */
	@Override
	public void storeHabit(HabitInfo habitInfo) {
		// TODO Auto-generated method stub
		habitInfoDao.save(habitInfo);
	}

	/*
	 *  查询用户健康数据
	 * */
	@Override
	public HabitInfo query(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		HabitInfo habitInfo = habitInfoDao.queryOne(query);
		if(habitInfo == null){
			log.info("用户 "+userId+"健康数据不存在，需要更新");
			return null;
		} else {
			return habitInfo;
		}
		
	}

	/*
	 *  更新用户健康数据
	 * */
	@Override
	public void update(HabitInfo habitInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(habitInfo.getUserId()));
		Update update = Update.update("cigarette", habitInfo.getCigarette()).addToSet("age", habitInfo.getAge()).
				addToSet("wine", habitInfo.getWine()).addToSet("salt", habitInfo.getSalt()).
				addToSet("weight", habitInfo.getWeight()).addToSet("inherit", habitInfo.isInherit());
		
		habitInfoDao.updateFirst(query, update);
		
	}
	
	
}
