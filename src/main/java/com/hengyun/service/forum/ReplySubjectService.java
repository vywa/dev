package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.ReplySubject;
import com.hengyun.service.BaseService;

public interface ReplySubjectService  extends BaseService<ReplySubject,Integer> {

	public int post(ReplySubject forumPost,int userId);
	
	public void delete(int subjectId);
	
	//查询前后十条帖子
	public List<ReplySubject> showList( int userId,int subjectId,int replyId ) ;
	
	public List<ReplySubject> show();
	
	public List<ReplySubject> showAll();
	
	
}
