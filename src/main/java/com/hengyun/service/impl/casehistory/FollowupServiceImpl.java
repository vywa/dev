package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.FollowupDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.casehistory.Followup;
import com.hengyun.service.casehistory.FollowupService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午2:46:56
* 随访业务实现
*/
public class FollowupServiceImpl extends BaseServiceImpl<Followup,Integer> implements FollowupService{

	private static final Logger log = LoggerFactory.getLogger(FollowupServiceImpl.class);
	
	@Resource
	private FollowupDao followupDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *   添加随访
	 * */
	@Override
	public void addFollow(Followup followup) {
		// TODO Auto-generated method stub
		int followId = indexCollectionDao.updateIndex("followupId");
		followup.setId(followId);
		followupDao.save(followup);
		
	}

	/*
	 *   查询病人随访 
	 **/
	@Override
	public Followup queryPatient(int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientId)).with(new Sort(Direction.DESC, "followupId"));
		Followup followup = followupDao.queryOne(query);
		return followup;
	}

	/*
	 *   查询病人随访记录列表
	 * */
	@Override
	public List<Followup> queryPList(int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientId));
		List<Followup> flist = followupDao.queryList(query);
		return flist;
	}

}
