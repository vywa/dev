package com.hengyun.dao.impl.casehistory;

import com.hengyun.dao.casehistory.FollowupDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.casehistory.Followup;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午2:44:13
* 随访数据实现
*/
public class FollowupDaoImpl extends BaseMongodbDaoImpl<Followup,Integer> implements FollowupDao{

	@Override
	protected Class<Followup> getEntityClass() {
		// TODO Auto-generated method stub
		return Followup.class;
	}

}
