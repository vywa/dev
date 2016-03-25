package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.Subject;
import com.hengyun.service.BaseService;

public interface SubjectService  extends BaseService<Subject,Integer> {

	/*
	 *  某人发表帖子
	 * */
	public int post(Subject forumPost,int userId);
	
	/*
	 *  删除某个帖子
	 * */
	public void delete(int subjectId);
	
	//查询前后十条帖子
	public List<Subject> showList( int userId,int subjectId,int subjectType ,int freshenType) ;
	
	public List<Subject> show(int userId,int watcher);
	
	/*
	 *  查询自己帖子
	 * */
	public List<Subject> querySelf(int userId);
	
	public List<Subject> showAll();
	
	/*
	 *  查询所有好友的帖子
	 * */
	public List<Subject> friendsSubject(int userId,int freshenType);
	
	/*
	 *  查询某个好友的帖子
	 * */
	public List<Subject> friendSubject(int userId,int friendId,int freshenType) ;
	
	/*
	 *  查看某个帖子详情
	 * */
	public Subject subjectDetail(int subjectId) ;
	
}
