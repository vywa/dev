package com.hengyun.dao.impl.administrator;

import com.hengyun.dao.administrator.UserRoleDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.administrator.UserRole;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:47:19
* 用户角色数据访问层
*/
public class UserRoleDaoImpl extends BaseMongodbDaoImpl<UserRole,Integer> implements UserRoleDao{

	@Override
	protected Class<UserRole> getEntityClass() {
		// TODO Auto-generated method stub
		return UserRole.class;
	}



}
