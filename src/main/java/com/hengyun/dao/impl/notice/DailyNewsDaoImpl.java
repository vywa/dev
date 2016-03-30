package com.hengyun.dao.impl.notice;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.notice.DailyNewsDao;
import com.hengyun.domain.notice.DailyNews;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 下午2:23:08
* 推送消息数据实现类
*/
public class DailyNewsDaoImpl extends BaseMongodbDaoImpl<DailyNews,Integer> implements DailyNewsDao{

	@Override
	protected Class<DailyNews> getEntityClass() {
		// TODO Auto-generated method stub
		return DailyNews.class;
	}

}
