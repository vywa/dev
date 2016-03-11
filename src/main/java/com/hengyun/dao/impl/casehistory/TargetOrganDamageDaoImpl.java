package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.TargetOrganDamageDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.TargetOrganDamage;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午5:38:59
* 靶组织受损数据层
*/
public class TargetOrganDamageDaoImpl extends BaseMongodbDaoImpl<TargetOrganDamage,Integer> implements TargetOrganDamageDao{

	@Override
	protected Class<TargetOrganDamage> getEntityClass() {
		// TODO Auto-generated method stub
		return TargetOrganDamage.class;
	}

}
