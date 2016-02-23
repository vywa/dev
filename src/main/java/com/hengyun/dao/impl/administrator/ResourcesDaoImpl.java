package com.hengyun.dao.impl.administrator;

import com.hengyun.dao.administrator.ResourcesDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.administrator.Resources;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:51:19
* 资源访问
*/
public class ResourcesDaoImpl extends BaseMongodbDaoImpl<Resources,Integer> implements ResourcesDao{

	@Override
	protected Class<Resources> getEntityClass() {
		// TODO Auto-generated method stub
		return Resources.class;
	}

}
