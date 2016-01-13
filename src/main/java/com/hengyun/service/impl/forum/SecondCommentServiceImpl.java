package com.hengyun.service.impl.forum;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.ForumPostDao;
import com.hengyun.dao.forum.SecondCommentDao;
import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.domain.forum.SecondComment;
import com.hengyun.service.forum.SecondCommentService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  　个人信息管理
 * */

public class SecondCommentServiceImpl extends BaseServiceImpl<SecondComment,Integer> implements SecondCommentService{

	@Resource
	private SecondCommentDao secondCommentDao;
	
	@Resource
	private ForumPostDao forumPostDao;
	
	@Resource 
	private InformationDao informationDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	
	
	//保存文件
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		this.save(in, filename);
	}
	
	//下载文件
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return this.retrieveFileOne(filename);
	}



	//更新资料
	public int update(ForumPost forumPost,String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Query query = Query.query(Criteria.where("userId").is(userId));
			Update update = Update.update("title","title").set("title", "hello");
			forumPostDao.updateFirst(query, update);
			return 0;
		} 
			return -1;
	
	}

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

	public int post(SecondComment comment, int commentId) {
		// TODO Auto-generated method stub
		return  secondCommentDao.addComment(comment, commentId);
		
		
	}

	public List<SecondComment> show() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("commentId").exists(true));
		return secondCommentDao.queryList(query);
	}

}
