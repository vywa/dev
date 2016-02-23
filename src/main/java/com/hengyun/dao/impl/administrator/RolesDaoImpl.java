package com.hengyun.dao.impl.administrator;

import com.hengyun.dao.administrator.RolesDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.administrator.Roles;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:49:31
*角色操作类
*/
public class RolesDaoImpl extends BaseMongodbDaoImpl<Roles,Integer> implements RolesDao{

	@Override
	protected Class<Roles> getEntityClass() {
		// TODO Auto-generated method stub
		return Roles.class;
	}

}
