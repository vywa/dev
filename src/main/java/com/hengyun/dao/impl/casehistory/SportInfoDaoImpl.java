package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.SportInfoDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.SportInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:14:49
* 类说明
*/
public class SportInfoDaoImpl extends BaseMongodbDaoImpl<SportInfo,Integer> implements SportInfoDao{

	@Override
	protected Class<SportInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return SportInfo.class;
	}

}
