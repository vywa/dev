package com.hengyun.domain.forum;

import java.io.Serializable;

/*
 *  论坛回复内容
 * 
 * */
public class CommentContent implements Serializable{

	private String contentType;					//回复内容类型 (文本，图片，声音，视频)
	
	private String message;							//回复消息

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
