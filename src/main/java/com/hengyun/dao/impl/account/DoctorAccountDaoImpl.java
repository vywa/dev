package com.hengyun.dao.impl.account;

import com.hengyun.dao.account.DoctorAccountDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.account.DoctorInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午2:34:24
* 类说明
*/
public class DoctorAccountDaoImpl extends BaseMongodbDaoImpl<DoctorInfo,Integer> implements DoctorAccountDao{

	@Override
	protected Class<DoctorInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return DoctorInfo.class;
	}

}
