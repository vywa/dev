package com.hengyun.dao.impl.system;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.system.AppVersionUpdateDao;
import com.hengyun.domain.system.AppVersionUpdate;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午4:59:35
* 版本更新数据访问层
*/
public class AppVersionUpdateDaoImpl extends BaseMongodbDaoImpl<AppVersionUpdate,Integer> implements AppVersionUpdateDao{

	@Override
	protected Class<AppVersionUpdate> getEntityClass() {
		// TODO Auto-generated method stub
		return AppVersionUpdate.class;
	}

}
