package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  用户权限
 * */
public class ForumAuthority implements Serializable{

	private  int userId;							//用户id
	private boolean post;					//允许发帖
	private boolean comment;		//允许回复
	private boolean cancel;				//允许删帖
	private boolean forumTemplate;					//创建板块
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isPost() {
		return post;
	}
	public void setPost(boolean post) {
		this.post = post;
	}
	public boolean isComment() {
		return comment;
	}
	public void setComment(boolean comment) {
		this.comment = comment;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	public boolean isForumTemplate() {
		return forumTemplate;
	}
	public void setForumTemplate(boolean forumTemplate) {
		this.forumTemplate = forumTemplate;
	}
	
	
	
}
