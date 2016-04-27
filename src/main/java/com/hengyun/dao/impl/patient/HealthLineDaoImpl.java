package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.HealthLineDao;
import com.hengyun.domain.patient.HealthLine;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 上午11:32:05
* 类说明
*/
public class HealthLineDaoImpl extends BaseMongodbDaoImpl<HealthLine,Integer> implements HealthLineDao{

	@Override
	protected Class<HealthLine> getEntityClass() {
		// TODO Auto-generated method stub
		return HealthLine.class;
	}

}
