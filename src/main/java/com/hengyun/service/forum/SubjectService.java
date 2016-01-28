package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.Subject;
import com.hengyun.service.BaseService;

public interface SubjectService  extends BaseService<Subject,Integer> {

	public int post(Subject forumPost,String tocken);
	
	public void delete(int subjectId);
	
	//查询前后十条帖子
	public List<Subject> showList( int userId,int subjectId,int subjectType ,int freshenType) ;
	
	public List<Subject> show(String tocken);
	
	public List<Subject> showAll();
	
	
}