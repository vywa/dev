package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.RiskFactorDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.RiskFactor;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午11:24:48
* 危险因素数据访问层
*/
public class RiskFactorDaoImpl extends BaseMongodbDaoImpl<RiskFactor,Integer> implements RiskFactorDao{

	@Override
	protected Class<RiskFactor> getEntityClass() {
		// TODO Auto-generated method stub
		return RiskFactor.class;
	}

}
