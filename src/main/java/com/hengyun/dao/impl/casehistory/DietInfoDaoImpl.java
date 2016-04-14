package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.DietInfoDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.DietInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:15:07
* 类说明
*/
public class DietInfoDaoImpl extends BaseMongodbDaoImpl<DietInfo,Integer> implements DietInfoDao{

	@Override
	protected Class<DietInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return DietInfo.class;
	}

}
