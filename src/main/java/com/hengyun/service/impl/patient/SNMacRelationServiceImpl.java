package com.hengyun.service.impl.patient;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.patient.SNMacRelationDao;
import com.hengyun.domain.patient.SNMacRelation;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.SNMacRelationService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月13日 下午4:54:26
* 类说明
*/
public class SNMacRelationServiceImpl extends BaseServiceImpl<SNMacRelation,Integer> implements SNMacRelationService{

	@Resource
	private SNMacRelationDao snMacRelationDao;
	@Override
	public void add(SNMacRelation snMacRelation) {
		// TODO Auto-generated method stub
		snMacRelationDao.save(snMacRelation);
	}

	@Override
	public String getSN(String mac) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("mac").is(mac));
		SNMacRelation smr = snMacRelationDao.queryOne(query);
		if(smr != null){
			return smr.getSn();
		}
		return null;
	}

}
