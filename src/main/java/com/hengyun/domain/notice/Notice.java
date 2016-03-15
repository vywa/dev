package com.hengyun.domain.notice;

import java.io.Serializable;
import java.util.Date;

/*
 * 
 *  通知类
 *  
 * */
public class Notice implements Serializable{

	private int 	noticeId;							//通知id
	
	private int		noticeFromId;				//通知来源
	
	private int		noticeToId;						//通知接收者
	
	private noticeType type;						//消息类型
	
	private String content;							//通知内容
	
	private int status;								//通知状态(0未处理,1处理)
	
	private String level;									//通知级别
	
	private Date sendTime;						//发送时间
	
	public enum noticeType{
		medical_notice,
		system_notice,
		friend_notice,
		forum_notice,
		
	}
	
	
	
	public int getNoticeId() {
		return noticeId;
	}



	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}



	public int getNoticeFromId() {
		return noticeFromId;
	}



	public void setNoticeFromId(int noticeFromId) {
		this.noticeFromId = noticeFromId;
	}



	public int getNoticeToId() {
		return noticeToId;
	}



	public void setNoticeToId(int noticeToId) {
		this.noticeToId = noticeToId;
	}



	public noticeType getType() {
		return type;
	}



	public void setType(noticeType type) {
		this.type = type;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}






	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public Date getSendTime() {
		return sendTime;
	}



	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}



	
}
