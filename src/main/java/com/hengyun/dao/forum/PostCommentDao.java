package com.hengyun.dao.forum;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.PostComment;

/*
 * 评论数据访问层
 * */
public interface PostCommentDao extends BaseMongodbDao<PostComment,Integer>{

	public int addComment(PostComment comment,int postId);
}
