package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.PostComment;
import com.hengyun.service.BaseService;

public interface PostCommentService  extends BaseService<PostComment,Integer> {

	public int comment(PostComment postComment,int postId);
	
	public List<PostComment> show();
	
}
