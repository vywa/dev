package com.hengyun.dao.impl.information;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.CollectionDao;
import com.hengyun.domain.information.Collection;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:28:11
* 收藏数据访问类
*/
public class CollectionDaoImpl extends BaseMongodbDaoImpl<Collection,Integer> implements CollectionDao{

	@Override
	protected Class<Collection> getEntityClass() {
		// TODO Auto-generated method stub
		return Collection.class;
	}

}
