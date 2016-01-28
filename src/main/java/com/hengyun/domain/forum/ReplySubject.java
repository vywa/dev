package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

/*
 *  		帖子回复
 * 
 * */

public class ReplySubject implements Serializable{

	/*
	 *  回复基本信息
	 */
	
	private int replyId;									//回帖的id
	
	private int 	userId;						//回复人ID
	
	private int subjectId;					//帖子id
	
	private String replyAuthorPhotoUrl;			//回复人图像地址
	
	private String replyAuthor;					//回复人姓名
	
	private  List<RepeatReply> repeatReply;					//对楼层的回复
	
	private String replyContent;
	
	private String replyLocInfo;				//回复地址信息
	
	private String replySoundUrl;
	
	private List<String> replyImgUrls;

	private String replyTime;					//回复时间
	
	
	
	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyAuthorPhotoUrl() {
		return replyAuthorPhotoUrl;
	}

	public void setReplyAuthorPhotoUrl(String replyAuthorPhotoUrl) {
		this.replyAuthorPhotoUrl = replyAuthorPhotoUrl;
	}

	public String getReplyAuthor() {
		return replyAuthor;
	}

	public void setReplyAuthor(String replyAuthor) {
		this.replyAuthor = replyAuthor;
	}

	public List<RepeatReply> getRepeatReply() {
		return repeatReply;
	}

	public void setRepeatReply(List<RepeatReply> repeatReply) {
		this.repeatReply = repeatReply;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyLocInfo() {
		return replyLocInfo;
	}

	public void setReplyLocInfo(String replyLocInfo) {
		this.replyLocInfo = replyLocInfo;
	}

	public String getReplySoundUrl() {
		return replySoundUrl;
	}

	public void setReplySoundUrl(String replySoundUrl) {
		this.replySoundUrl = replySoundUrl;
	}

	public List<String> getReplyImgUrls() {
		return replyImgUrls;
	}

	public void setReplyImgUrls(List<String> replyImgUrls) {
		this.replyImgUrls = replyImgUrls;
	}
	
	
	
}
