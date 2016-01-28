package com.hengyun.service.impl.forum;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.forum.ForumPostDao;
import com.hengyun.dao.forum.SecondCommentDao;
import com.hengyun.dao.information.InformationDao;
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

	
	public int post(SecondComment comment, int commentId) {
		// TODO Auto-generated method stub
		return  secondCommentDao.addComment(comment, commentId);
		
		
	}

	public List<SecondComment> show() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("commentID").exists(true));
		return secondCommentDao.queryList(query);
	}

}
