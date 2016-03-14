package com.hengyun.dao.logininfo;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.common.IndexCollection;

/*
 *  索引访问层
 * */
public interface IndexCollectionDao extends BaseMongodbDao<IndexCollection,Integer>{

	public boolean load();
	
	/*
	 * 根据索引名称自增索引
	 * */
	public int updateIndex(String name);
}
