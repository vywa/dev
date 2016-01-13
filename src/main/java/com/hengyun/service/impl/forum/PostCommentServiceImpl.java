package com.hengyun.service.impl.forum;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.forum.ForumPostDao;
import com.hengyun.dao.forum.PostCommentDao;
import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.domain.forum.PostComment;
import com.hengyun.service.forum.PostCommentService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  　个人信息管理
 * */

public class PostCommentServiceImpl extends BaseServiceImpl<PostComment,Integer> implements PostCommentService{

	@Resource
	private PostCommentDao postCommentDao;
	
	@Resource
	private ForumPostDao forumPostDao;
	
	@Resource 
	private InformationDao informationDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	
	
	public int  post(ForumPost forumPost,String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline( tocken);
		if(userId>0){
			forumPost.setUserId(userId);
			forumPost.setDeliveryTime(new Date());
			int postId = forumPostDao.post(forumPost);
			return postId;
		}
		return -1;
	}

	

	public List<ForumPost> show(String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Query query = Query.query(Criteria.where("userId").is(userId));
			List<ForumPost> forumPost = forumPostDao.queryList(query);
			return forumPost;
		} 
		return null;
	}



	public int comment(PostComment postComment, int postId) {
		// TODO Auto-generated method stub
		int commentId = postCommentDao.addComment(postComment, postId);
		return commentId;
	}



	public List<PostComment> show() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("commentId").exists(true));
		return postCommentDao.queryList(query);
	}

}
