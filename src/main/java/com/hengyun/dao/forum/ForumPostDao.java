package com.hengyun.dao.forum;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.domain.forum.PostComment;

/*
 * 帖子数据访问层
 * */
public interface ForumPostDao extends BaseMongodbDao<ForumPost,Integer>{

	//发帖
	public int post(ForumPost post);
	
	
}
