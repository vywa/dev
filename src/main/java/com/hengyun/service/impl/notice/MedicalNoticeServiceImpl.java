package com.hengyun.service.impl.notice;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.notice.MedicalNoticeDao;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.service.casehistory.DiagnosisService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.notice.MedicalNoticeService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午5:19:11
* 医疗通知业务实现类
*/
public class MedicalNoticeServiceImpl extends BaseServiceImpl<MedicalNotice, Integer> implements MedicalNoticeService{

	private static final Logger log = LoggerFactory.getLogger(MedicalNoticeServiceImpl.class);
	
	@Resource
	private MedicalNoticeDao medicalNoticeDao;
	
	@Resource
	private DiagnosisService diagnosisService;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  添加一条通知
	 * */
	@Override
	public void addNotice(MedicalNotice medicalNotice) {
		// TODO Auto-generated method stub
		int noticeId = indexCollectionDao.updateIndex("noticeId");
		medicalNotice.setNoticeId(noticeId);
		medicalNotice.setSendTime(new Date());
		medicalNotice.setStatus(0);
		medicalNoticeDao.save(medicalNotice);
		log.info("添加一条医疗通知");
		
	}

	/*
	 *  处理一条消息
	 * */
	@Override
	public void handleNotice(MedicalNotice medicalNotice) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("noticeId").is(medicalNotice.getNoticeId()));
		Update update = Update.update("status", 1);
		medicalNoticeDao.updateFirst(query, update);
	}

	/*
	 *  查询医生的所有未处理病人
	 * */
	@Override
	public List<MedicalNotice> queryNotice(int noticeFromId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("status").is(0)));
		List<MedicalNotice> mlist = medicalNoticeDao.queryList(query);
		return mlist;
	}

	/*
	 *  查询医生的某个病人的未处理消息
	 * */
	@Override
	public MedicalNotice query(int noticeFromId, int noticeToId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("noticeFromId").
			is(noticeFromId).andOperator(Criteria.where("noticeToId").
					is(noticeToId).andOperator(Criteria.where("status").is(0))));
		MedicalNotice medicalNotice = medicalNoticeDao.queryOne(query);
		return medicalNotice;
	}

}
