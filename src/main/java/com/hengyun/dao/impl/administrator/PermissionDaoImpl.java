package com.hengyun.dao.impl.administrator;

import com.hengyun.dao.administrator.PermissionDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.administrator.Permission;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:43:09
* 权限操作数据访问层
*/
public class PermissionDaoImpl extends BaseMongodbDaoImpl<Permission,Integer> implements PermissionDao{

	@Override
	protected Class<Permission> getEntityClass() {
		// TODO Auto-generated method stub
		return Permission.class;
	}
}