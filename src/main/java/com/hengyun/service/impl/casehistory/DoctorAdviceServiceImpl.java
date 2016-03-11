package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.DoctorAdviceDao;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.domain.casehistory.DoctorAdvice;
import com.hengyun.service.casehistory.DoctorAdviceService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午3:24:55
* 医嘱业务实现类
*/
public class DoctorAdviceServiceImpl extends BaseServiceImpl<DoctorAdvice,Integer> implements DoctorAdviceService{

	@Resource
	private DoctorAdviceDao doctorAdviceDao;
	
	@Resource
	private IndexCollectiontDao indexCollectionDao;
	
	/*
	 *  添加医嘱
	 * */
	@Override
	public boolean addAdvice(DoctorAdvice doctorAdvice) {
		// TODO Auto-generated method stub
		int adviceId = indexCollectionDao.updateIndex("doctorAdviceId");
		doctorAdvice.setDoctorAdviceId(adviceId);
		doctorAdviceDao.save(doctorAdvice);
		return true;
	}

	/*
	 *  更新医嘱
	 * */
	@Override
	public boolean updateAdvice(DoctorAdvice doctorAdvice) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorAdviceId").is(doctorAdvice.getDoctorAdviceId()));
		Update update = Update.update("content", doctorAdvice.getContent()).
				addToSet("recipes", doctorAdvice.getRecipes());
		doctorAdviceDao.updateFirst(query, update);
		return true;
	}

	/*
	 *  查看医嘱
	 * */
	@Override
	public DoctorAdvice queryAdvice(int doctorAdviceId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorAdviceId").is(doctorAdviceId));
		DoctorAdvice advice = doctorAdviceDao.queryOne(query);
		if(advice != null) {
			return advice;
		} else {
			return null;
		}
	}

	/*
	 *  查询病历所有医嘱
	 * */
	@Override
	public List<DoctorAdvice> queryAdviceList(int caseHistoryId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("caseHistoryId").is(caseHistoryId));
		List<DoctorAdvice> advices = doctorAdviceDao.queryList(query);
		if(advices != null) {
			return advices;
		} else {
			return null;
		}
	}

	
}
