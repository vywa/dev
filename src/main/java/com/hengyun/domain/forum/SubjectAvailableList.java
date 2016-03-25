package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 上午10:43:16
* 用户可见用户列表
*/
public class SubjectAvailableList implements Serializable{

	
	private int authorId;										//用户id
	private List<Integer>  available;						//可被看
	private List<Integer>  subscribe;							//订阅用户
	private boolean publicSee;						//公开
	
	
	public boolean isPublicSee() {
		return publicSee;
	}
	
	public void setPublicSee(boolean publicSee) {
		this.publicSee = publicSee;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public List<Integer> getAvailable() {
		return available;
	}

	public void setAvailable(List<Integer> available) {
		this.available = available;
	}

	public List<Integer> getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(List<Integer> subscribe) {
		this.subscribe = subscribe;
	}

	
	
}
