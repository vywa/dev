package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.SecondComment;
import com.hengyun.service.BaseService;

public interface SecondCommentService  extends BaseService<SecondComment,Integer> {

	public int post(SecondComment comment,int commentId);
	
	public List<SecondComment> show();
	
}
