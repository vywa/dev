package com.hengyun.domain.monitor;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午3:18:39
* 系统消息历史记录表
*/
public class SystemMessageHistory implements Serializable{

	private int messageId;										//消息id
	private MessageTyep messageType;			//消息类型
	private String content;										//消息内容
	private Date createTime;									//创建时间

	public enum MessageTyep{
		system_upgrade,
		system_announce,
		group_operation,
		chat_message,
		business_message
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public MessageTyep getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageTyep messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
