package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.ReTreateInfoDao;
import com.hengyun.domain.casehistory.ReTreateInfo;
import com.hengyun.service.casehistory.ReTreateInfoService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　回访信息管理
 * */

public class ReTreateInfoServiceImpl extends BaseServiceImpl<ReTreateInfo,Integer> implements ReTreateInfoService{

	@Resource 
	private ReTreateInfoDao reTreateInfoDao;

	public List<ReTreateInfo> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return reTreateInfoDao.queryList(query);
		
	}

	public int addReTreateInfo(ReTreateInfo reTreateInfo) {
		// TODO Auto-generated method stub
		return reTreateInfoDao.addReTreate(reTreateInfo);
	}


	

}
