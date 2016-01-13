package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.CaseHistoryDao;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.hospital.Office;
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


	
	

}
