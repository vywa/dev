package com.hengyun.service.impl.casehistory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.SportInfoDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.casehistory.SportInfo;
import com.hengyun.service.casehistory.SportInfoService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:19:33
* 类说明
*/
public class SportInfoServiceImpl extends BaseServiceImpl<SportInfo,Integer> implements SportInfoService{

	@Resource
	private SportInfoDao sportInfoDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	/*
	 *  添加运动
	 * */
	@Override
	public void addSport(SportInfo sportInfo) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("sportId");
		sportInfo.setId(id);
		sportInfoDao.save(sportInfo);
	}

	@Override
	public List<SportInfo> getSportList(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<SportInfo> list = sportInfoDao.queryList(query);
		return list;
	}

	@Override
	public void delete(int userId, int id) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId).andOperator(Criteria.where("id").is(id)));
		sportInfoDao.delete(query);
	}

}
