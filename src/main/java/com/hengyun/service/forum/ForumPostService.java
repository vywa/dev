package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.ForumPost;
import com.hengyun.service.BaseService;

public interface ForumPostService  extends BaseService<ForumPost,Integer> {

	public int post(ForumPost forumPost,String tocken);
	
	public List<ForumPost> show(String tocken);
	
	public List<ForumPost> showAll();
	
	
}
