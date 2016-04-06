package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.CaseHistoryDao;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.service.casehistory.CaseHistoryService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　病历信息管理
 * */

public class CaseHistoryServiceImpl extends BaseServiceImpl<CaseHistory,Integer> implements CaseHistoryService{

	@Resource 
	private CaseHistoryDao caseHistoryDao;

	public List<CaseHistory> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return caseHistoryDao.queryList(query);
		
	}
	
	

	public int addCaseHistory(CaseHistory caseHistory) {
		// TODO Auto-generated method stub
		return caseHistoryDao.addCaseHistory(caseHistory);
	}


	/*
	 *  查询某个病历
	 * */
	@Override
	public CaseHistory query(int caseHistoryId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("caseHistoryId").is(caseHistoryId));
		CaseHistory caseHistory = caseHistoryDao.queryOne(query);
		if(caseHistory != null){
			return caseHistory;
		}
		return null;
	}
	
	/*
	 *  根据病历查找病人
	 * */
	@Override
	public int getPatientId(int caseHistoryId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("caseHistoryId").is(caseHistoryId));
		CaseHistory caseHistory = caseHistoryDao.queryOne(query);
		int patientId = caseHistory.getPatientId();
		return patientId;
	}



	@Override
	public int getDoctorId(int caseHistoryId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("caseHistoryId").is(caseHistoryId));
		CaseHistory caseHistory = caseHistoryDao.queryOne(query);
		int doctorId = caseHistory.getDocterId();
		return doctorId;
	}



	/*
	 * 
	 *  获取病人最后一次病历
	 * 
	 * */
	@Override
	public int  getPatientLatest(int patientId) {
		// TODO Auto-generated method stub
		Query  query = new Query();
	     Criteria criteria = Criteria.where("patientId").is(patientId);
	      query.addCriteria(criteria).with(new Sort(Direction.DESC, "measureTime"));
	      CaseHistory caseHistory = caseHistoryDao.queryOne(query);
	      if(caseHistory!=null){
	    	  return caseHistory.getCaseHistoryId();
	      } else {
	    	  return -1;
	      }
		
	}

}
