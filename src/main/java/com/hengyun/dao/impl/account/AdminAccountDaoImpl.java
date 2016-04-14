package com.hengyun.dao.impl.account;

import com.hengyun.dao.account.AdminAccountDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.account.AdminInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午2:34:37
* 类说明
*/
public class AdminAccountDaoImpl extends BaseMongodbDaoImpl<AdminInfo,Integer> implements AdminAccountDao{

	@Override
	protected Class<AdminInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return AdminInfo.class;
	}

}
