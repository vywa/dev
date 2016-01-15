package com.hengyun.dao.impl.forum;

import com.hengyun.dao.forum.ForumAuthorityDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.forum.ForumAuthority;


/*
 *   论坛权限管理
 * */

public class ForumAuthorityDaoImpl extends BaseMongodbDaoImpl<ForumAuthority,Integer> implements ForumAuthorityDao{


	@Override
	protected Class<ForumAuthority> getEntityClass() {
		// TODO Auto-generated method stub
		return ForumAuthority.class;
	}
    
}
