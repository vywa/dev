package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 *  		帖子回复
 * 
 * */

public class PostComment implements Serializable{

	/*
	 *  回复基本信息
	 * 
	 * */
	private int id;									//回复id
	
	
	private int 	replyToId;					//回复评论的id;
	
	
	private String replyerName;			//回复人名称
	
	private int 	replyerId;						//回复人ID
	
	
	private Date 		replyTime;												//回复时间
	
	private CommentContent comment;						//回复内容
	
	/*
	 * 
	 *  回复处理
	 * 
	 * */

	private String status;						//回复状态 (屏蔽，正常)
	

	private List<Integer> 	commentList;				//回复的回复


	

	public CommentContent getComment() {
		return comment;
	}


	public void setComment(CommentContent comment) {
		this.comment = comment;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getReplyToId() {
		return replyToId;
	}


	public void setReplyToId(int replyToId) {
		this.replyToId = replyToId;
	}


	public String getReplyerName() {
		return replyerName;
	}


	public void setReplyerName(String replyerName) {
		this.replyerName = replyerName;
	}


	public int getReplyerId() {
		return replyerId;
	}


	public void setReplyerId(int replyerId) {
		this.replyerId = replyerId;
	}


	public Date getReplyTime() {
		return replyTime;
	}


	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Integer> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<Integer> commentList) {
		this.commentList = commentList;
	}


	
	
}
