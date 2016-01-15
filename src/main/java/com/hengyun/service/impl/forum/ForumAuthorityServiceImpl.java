package com.hengyun.service.impl.forum;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.forum.ForumAuthorityDao;
import com.hengyun.domain.forum.ForumAuthority;
import com.hengyun.service.forum.ForumAuthorityService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　权限管理
 * */

public class ForumAuthorityServiceImpl extends BaseServiceImpl<ForumAuthority,Integer> implements ForumAuthorityService{

	@Resource
	private ForumAuthorityDao forumAuthorityDao;
	
	
	public int addAuthority(ForumAuthority forumAuthority){
		forumAuthorityDao.save(forumAuthority);
		return 0;
	}


	public List<ForumAuthority> show() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		return forumAuthorityDao.queryList(query);
	}

}
