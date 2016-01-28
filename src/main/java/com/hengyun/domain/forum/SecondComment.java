package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.Date;

/*
 *  		帖子回复的回复
 * 
 * */

public class SecondComment implements Serializable{

	/*
	 *  回复基本信息
	 * 
	 * */
	private int id;									//回复id
	
	
	private int 	replyToId;					//回复评论的id;
	
	
	private String replyerName;			//回复人名称
	
	private int 	replyerId;						//回复人ID
	
	private CommentContent 	commonContents;					//二次回复内容
	
	private Date 		replyTime;												//回复时间
	
	/*
	 * 
	 *  回复处理
	 * 
	 * */

	private String status;						//回复状态 (屏蔽，正常)
	


	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	public CommentContent getCommonContents() {
		return commonContents;
	}


	public void setCommonContents(CommentContent commonContents) {
		this.commonContents = commonContents;
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

	
}
