package com.hengyun.dao.impl.account;

import com.hengyun.dao.account.PatientAccountDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.account.PatientInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午2:34:06
* 类说明
*/
public class PatientAccountDaoImpl extends BaseMongodbDaoImpl<PatientInfo,Integer> implements PatientAccountDao{

	@Override
	protected Class<PatientInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return PatientInfo.class;
	}

}
