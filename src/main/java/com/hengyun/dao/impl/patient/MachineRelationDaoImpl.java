package com.hengyun.dao.impl.patient;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.patient.MachineRelationDao;
import com.hengyun.domain.patient.MachineRelation;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月10日 上午11:49:23
* 类说明
*/
public class MachineRelationDaoImpl extends BaseMongodbDaoImpl<MachineRelation,Integer> implements MachineRelationDao{

	@Override
	protected Class<MachineRelation> getEntityClass() {
		// TODO Auto-generated method stub
		return MachineRelation.class;
	}

}
