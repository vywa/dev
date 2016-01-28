package com.hengyun.dao.forum;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.Subject;

/*
 * 帖子数据访问层
 * */
public interface SubjectDao extends BaseMongodbDao<Subject,Integer>{

	//发帖
	public int post(Subject post);
	
	
}
