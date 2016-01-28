package com.hengyun.domain.common;

import java.io.Serializable;

/*
 *  数据库中自增索引
 * */
public class IndexCollection implements Serializable{

	private int docterID;									//初始值100000000
	private int patientID;								//初始值200000000
	private int caseHistoryID;						//病历初值
	private int reTreateInfoID;						//回访表
	private int adminID;									//管理员０
	private int postID;										//帖子id
	private int commentID;							//回复id
	private int forumTemplateID;				//板块id
	private int multiMediaID;						//多媒体信息id
	
	
	public int getMultiMediaID() {
		return multiMediaID;
	}
	public void setMultiMediaID(int multiMediaID) {
		this.multiMediaID = multiMediaID;
	}
	public int getReTreateInfoID() {
		return reTreateInfoID;
	}
	public void setReTreateInfoID(int reTreateInfoID) {
		this.reTreateInfoID = reTreateInfoID;
	}
	public int getCaseHistoryID() {
		return caseHistoryID;
	}
	public void setCaseHistoryID(int caseHistoryID) {
		this.caseHistoryID = caseHistoryID;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}

	
	
	
	public int getDocterID() {
		return docterID;
	}
	public void setDocterID(int docterID) {
		this.docterID = docterID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getForumTemplateID() {
		return forumTemplateID;
	}
	public void setForumTemplateID(int forumTemplateID) {
		this.forumTemplateID = forumTemplateID;
	}
	
	
}
