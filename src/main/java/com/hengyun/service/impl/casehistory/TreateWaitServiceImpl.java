package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.TreateWaitDao;
import com.hengyun.domain.casehistory.TreateWait;
import com.hengyun.service.casehistory.TreateWaitService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　就诊信息管理
 * */

public class TreateWaitServiceImpl extends BaseServiceImpl<TreateWait,Integer> implements TreateWaitService{

	@Resource 
	private TreateWaitDao  treateWaitDao;

	public List<TreateWait> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return treateWaitDao.queryList(query);
		
	}


	

}
