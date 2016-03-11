package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.DoctorAdviceDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.DoctorAdvice;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午3:16:58
* 医嘱数据访问层
*/
public class DoctorAdviceDaoImpl extends BaseMongodbDaoImpl<DoctorAdvice,Integer> implements DoctorAdviceDao{

	@Override
	protected Class<DoctorAdvice> getEntityClass() {
		// TODO Auto-generated method stub
		return DoctorAdvice.class;
	}

}
