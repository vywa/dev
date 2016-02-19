package com.hengyun.domain.im;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月18日 下午3:26:02
* 聊天信息类
*/
public class ChatLog implements Serializable{

	int messageId;										//消息id
	String sessionJID;									//用户sessionjid名称　
	String sender;											//消息发送者
	String receiver;										//消息接受者
	Date createTime;									//消息发送时间
	int length;												//消息长度
	String cotent;											//消息内容
	String detail;											//消息源报文
	int 	state;													//是否删除，１代表删除
	
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getSessionJID() {
		return sessionJID;
	}
	public void setSessionJID(String sessionJID) {
		this.sessionJID = sessionJID;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getCotent() {
		return cotent;
	}
	public void setCotent(String cotent) {
		this.cotent = cotent;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
