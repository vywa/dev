package com.hengyun.dao.forum;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.SecondComment;

/*
 * 评论数据访问层
 * */
public interface SecondCommentDao extends BaseMongodbDao<SecondComment,Integer>{

	public int addComment(SecondComment comment,int commentId);
}
