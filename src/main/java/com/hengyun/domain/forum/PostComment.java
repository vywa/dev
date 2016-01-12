package com.hengyun.domain.forum;

import java.io.Serializable;
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
	private int id;							//回复id
	
	private String type;						//回复的类型（主贴回复，别人评论回复）
	
	private int 	replyToId;					//回复评论的id;
	
	
	private String replyerName;			//回复人名称
	
	private int 	replyerId;						//回复人ID
	
	private List<CommonContent> 	commonContents;					//回复内容
	
	
	/*
	 * 
	 *  回复处理
	 * 
	 * */

	private String status;						//回复状态 (屏蔽，正常)
	

	private List<CommonContent> 	commentList;				//回复的回复


	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	

	public List<CommonContent> getCommonContents() {
		return commonContents;
	}


	public void setCommonContents(List<CommonContent> commonContents) {
		this.commonContents = commonContents;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<CommonContent> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<CommonContent> commentList) {
		this.commentList = commentList;
	}

	
	
	
}
