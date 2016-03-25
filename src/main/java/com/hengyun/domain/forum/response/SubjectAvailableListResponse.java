package com.hengyun.domain.forum.response;

import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午1:42:56
* 权限结果类
*/
public class SubjectAvailableListResponse extends ResponseCode{

	private int authorId;										//用户id
	private List<Integer>  available;						//可被看
	private List<Integer>  subscribe;							//订阅用户
	private boolean publicSee;						//公开
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
	public boolean isPublicSee() {
		return publicSee;
	}
	public void setPublicSee(boolean publicSee) {
		this.publicSee = publicSee;
	}
	public SubjectAvailableListResponse() {
		super();
	}
	
	
	
}
