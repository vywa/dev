package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.AffiliatedClinicalDiseaseDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.AffiliatedClinicalDisease;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 上午9:29:29
* 伴随临床疾患数据访问层
*/
public class AffiliatedClinicalDiseaseDaoImpl extends BaseMongodbDaoImpl<AffiliatedClinicalDisease,Integer> implements AffiliatedClinicalDiseaseDao{

	@Override
	protected Class<AffiliatedClinicalDisease> getEntityClass() {
		// TODO Auto-generated method stub
		return AffiliatedClinicalDisease.class;
	}

}
