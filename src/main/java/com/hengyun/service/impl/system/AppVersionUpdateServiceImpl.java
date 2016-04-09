package com.hengyun.service.impl.system;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.system.AppVersionUpdateDao;
import com.hengyun.domain.system.AppVersionUpdate;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.system.AppVersionUpdateService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午5:02:29
* 版本更新业务层
*/
public class AppVersionUpdateServiceImpl extends BaseServiceImpl<AppVersionUpdate,Integer> implements AppVersionUpdateService{

	@Resource
	private AppVersionUpdateDao appVersionUpdateDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	/*
	 *  获取最新版本
	 * */
	@Override
	public AppVersionUpdate getLatest(String type) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("type").is(type)).with(new Sort(Direction.DESC, "id"));
		AppVersionUpdate app=appVersionUpdateDao.queryOne(query);
		return app;
	}

	/*
	 *  添加版本更新
	 * */
	@Override
	public void addUpdate(AppVersionUpdate appVersionUpdate) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("updateId");
		appVersionUpdate.setId(id);
		appVersionUpdate.setDate(new Date());
		appVersionUpdateDao.save(appVersionUpdate);
	}

}
