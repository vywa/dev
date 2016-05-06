package com.hengyun.dao.impl.im;

import com.hengyun.dao.im.IMContentDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.im.IMContent;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月6日 上午8:22:18
* 类说明
*/
public class IMContentDaoImpl extends BaseMongodbDaoImpl<IMContent,Integer> implements IMContentDao{

	@Override
	protected Class<IMContent> getEntityClass() {
		// TODO Auto-generated method stub
		return IMContent.class;
	}

}
