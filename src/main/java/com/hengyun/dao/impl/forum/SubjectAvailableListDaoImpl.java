package com.hengyun.dao.impl.forum;

import com.hengyun.dao.forum.SubjectAvailableListDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.forum.SubjectAvailableList;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 上午11:04:17
* 朋友圈权限管理数据实现类
*/
public class SubjectAvailableListDaoImpl extends BaseMongodbDaoImpl<SubjectAvailableList,Integer> implements SubjectAvailableListDao{

	@Override
	protected Class<SubjectAvailableList> getEntityClass() {
		// TODO Auto-generated method stub
		return SubjectAvailableList.class;
	}

}
