package com.hengyun.dao.forum;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.ReplySubject;

/*
 * 帖子数据访问层
 * */
public interface ReplySubjectDao extends BaseMongodbDao<ReplySubject,Integer>{

	//发帖
	public int post(ReplySubject post);
	
	
}
