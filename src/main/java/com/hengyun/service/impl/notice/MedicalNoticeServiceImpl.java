package com.hengyun.service.impl.notice;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public void handleNotice(int  noticeId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("noticeId").is(noticeId));
		Update update = Update.update("status", 1);
		medicalNoticeDao.updateFirst(query, update);
	}

	/*
	 *  查询医生的所有未处理病人
	 * */
	@Override
	public List<MedicalNotice> queryNotice(int noticeFromId,int freshenType,int noticeId) {
		// TODO Auto-generated method stub
		List<MedicalNotice> mnList =null;
		Query query = new Query();
		Criteria criteria =Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("noticeId").gt(noticeId)
				.andOperator(Criteria.where("status").is(0)));
		  query.addCriteria(criteria).with(new Sort(Direction.ASC, "noticeId"));
			Query query2 = new Query();
			Criteria criteria2 =Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("noticeId").lt(noticeId)
					.andOperator(Criteria.where("status").is(0)));
		query2.addCriteria(criteria2).with(new Sort(Direction.DESC, "noticeId"));
		  
		if(freshenType== -1){
	
			mnList = medicalNoticeDao.getPage(query, 0, 10);
		}
		else if(freshenType==1){
		
			mnList = medicalNoticeDao.getPage(query2, 0, 10);
		}

		return mnList;
	}

	/*
	 *  查询医生的某个病人的未处理消息
	 * */
	@Override
	public List<MedicalNotice> query(int noticeFromId,List<Integer> list) {
		// TODO Auto-generated method stub
		List<MedicalNotice> mnList =null;

		Query query = Query.query(Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("noticeToId").
				in(list).andOperator(Criteria.where("status").is(0)))).with(new Sort(Direction.ASC, "noticeId"));
		
		Query query2 = Query.query(Criteria.where("noticeFromId").is(noticeFromId).
				andOperator(Criteria.where("noticeToId").in(list).andOperator(Criteria.where("status").is(0)))).with(new Sort(Direction.DESC, "noticeId"));
		
		mnList= medicalNoticeDao.queryList(query2);

		return mnList;
	}

	/*
	 *  医生查询自己病人某种病的通知
	 * */
	@Override
	public List<MedicalNotice> doctorQuery(int noticeFromId, int freshenType, int noticeId, int type) {
		// TODO Auto-generated method stub
		List<MedicalNotice> mnList =null;
		Query query = Query.query(Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("type").is(type)
				.andOperator(Criteria.where("noticeId").gt(noticeId)
				.andOperator(Criteria.where("status").is(0))))).
				with(new Sort(Direction.ASC, "noticeId"));
		Query query2 = Query.query(Criteria.where("noticeFromId").is(noticeFromId).andOperator(Criteria.where("noticeToId").is(type)
				.andOperator(Criteria.where("noticeId").lt(noticeId)
				.andOperator(Criteria.where("status").is(0))))).
				with(new Sort(Direction.DESC, "noticeId"));
		  
		if(freshenType== -1){
	
			mnList = medicalNoticeDao.getPage(query, 0, 10);
		}
		else if(freshenType==1){
		
			mnList = medicalNoticeDao.getPage(query2, 0, 10);
		}

		return mnList;
	}

}
