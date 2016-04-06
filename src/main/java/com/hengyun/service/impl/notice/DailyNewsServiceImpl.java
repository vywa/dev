package com.hengyun.service.impl.notice;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.notice.DailyNewsDao;
import com.hengyun.domain.notice.DailyNews;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.notice.DailyNewsService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 下午2:28:19
* 类说明
*/
public class DailyNewsServiceImpl extends BaseServiceImpl<DailyNews, Integer> implements DailyNewsService{

	private static final Logger log = LoggerFactory.getLogger(DailyNewsServiceImpl.class);
	
	@Resource
	private DailyNewsDao dailyNewsDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	@Override
	public void add(DailyNews dn) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("newsId");
		dn.setId(id);
		dn.setPublishTime(new Date());
		dailyNewsDao.save(dn);
	}

	@Override
	public DailyNews query(int id) {
		// TODO Auto-generated method stub
		DailyNews dn = dailyNewsDao.queryById(id);
		return dn;
	}

	/*
	 * 
	 *  查询资讯列表
	 * 
	 * */
	@Override
	public List<DailyNews> queryList() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		List<DailyNews> list = dailyNewsDao.queryList(query);
		return list;
	}

}
