package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.DietInfoDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.casehistory.DietInfo;
import com.hengyun.service.casehistory.DietInfoService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:20:19
* 类说明
*/
public class DietInfoServiceImpl extends BaseServiceImpl<DietInfo,Integer> implements DietInfoService{

	@Resource
	private DietInfoDao dietInfoDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	@Override
	public void addDiet(DietInfo dietInfo) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("dietId");
		dietInfo.setId(id);
		dietInfoDao.save(dietInfo);
	}

	@Override
	public List<DietInfo> getDietList(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<DietInfo> list = dietInfoDao.queryList(query);
		return list;
	}

	@Override
	public void delete(int userId, int id) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").is(id)));
		dietInfoDao.delete(query);
	}

}
