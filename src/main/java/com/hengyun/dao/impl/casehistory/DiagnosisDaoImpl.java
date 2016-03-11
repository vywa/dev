package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.DiagnosisDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.Diagnosis;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午10:07:09
* 诊断结果数据访问层
*/
public class DiagnosisDaoImpl extends BaseMongodbDaoImpl<Diagnosis,Integer> implements DiagnosisDao{

	@Override
	protected Class<Diagnosis> getEntityClass() {
		// TODO Auto-generated method stub
		return Diagnosis.class;
	}

}
