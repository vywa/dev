package com.hengyun.domain.common;

import java.io.Serializable;

/*
 *  数据库中自增索引
 * */
public class IndexCollection implements Serializable{

	private int docterID;									//初始值100000000
	private int patientID;								//初始值200000000
	private int postID;										//帖子ｉｄ
	private int commnetId;							//回复ｉｄ
	private int forumTemplateId;				//板块ｉｄ
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getCommnetId() {
		return commnetId;
	}
	public void setCommnetId(int commnetId) {
		this.commnetId = commnetId;
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
	public int getForumTemplateId() {
		return forumTemplateId;
	}
	public void setForumTemplateId(int forumTemplateId) {
		this.forumTemplateId = forumTemplateId;
	}
	
	
}
