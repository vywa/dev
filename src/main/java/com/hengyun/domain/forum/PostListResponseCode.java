package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.BaseResponseCode;

/*
 *  返回码基类，由标志码和描述信息组成
 * */
public  class PostListResponseCode extends BaseResponseCode implements Serializable{
	private int responseCode;								//返回码
	private String description;								//描述
	private List<Subject> subjectList;					//文件存储地址
	
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	
	
}
