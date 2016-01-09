package com.hengyun.dao.logininfo;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.loginInfo.UserAccount;

/*
 *  账号数据访问层
 * */
public interface IndexCollectiontDao extends BaseMongodbDao<IndexCollection,Integer>{

	public boolean load();
}
