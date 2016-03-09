package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.HealthTargetDao;
import com.hengyun.domain.patient.HealthTarget;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月9日 下午4:17:53
* 健康目标数据层
*/
public class HealthTargetDaoImpl extends BaseMongodbDaoImpl<HealthTarget,Integer> implements HealthTargetDao{

	@Override
	protected Class<HealthTarget> getEntityClass() {
		// TODO Auto-generated method stub
		return HealthTarget.class;
	}

}
