package com.hengyun.dao.casehistory;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.casehistory.ReTreateInfo;

/*
 *  回访数据访问层
 * */
public interface ReTreateInfoDao extends BaseMongodbDao<ReTreateInfo,Integer>{

	public int addReTreate(ReTreateInfo reTreateInfo);
}
