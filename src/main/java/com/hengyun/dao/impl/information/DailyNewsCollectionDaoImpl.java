package com.hengyun.dao.impl.information;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.DailyNewsCollectionDao;
import com.hengyun.domain.information.DailyNewsCollection;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月6日 下午2:12:27
* 收藏实现类
*/
public class DailyNewsCollectionDaoImpl  extends BaseMongodbDaoImpl<DailyNewsCollection,Integer> implements DailyNewsCollectionDao{

	@Override
	protected Class<DailyNewsCollection> getEntityClass() {
		// TODO Auto-generated method stub
		return DailyNewsCollection.class;
	}

}
