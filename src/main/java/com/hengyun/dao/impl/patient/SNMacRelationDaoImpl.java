package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.SNMacRelationDao;
import com.hengyun.domain.patient.SNMacRelation;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月13日 下午4:51:11
* 类说明
*/
public class SNMacRelationDaoImpl extends BaseMongodbDaoImpl<SNMacRelation,Integer> implements SNMacRelationDao{

	@Override
	protected Class<SNMacRelation> getEntityClass() {
		// TODO Auto-generated method stub
		return SNMacRelation.class;
	}

}
