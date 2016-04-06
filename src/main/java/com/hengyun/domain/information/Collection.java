package com.hengyun.domain.information;

import java.io.Serializable;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:07:19
* 收藏类
*/
public class Collection implements Serializable{

	private int 										userId;					//用户id
	
	private List<DailyNewsCollection> 						subjectList;			//帖子收藏
	private List<DailyNewsCollection> 						dailyNewsList;		//每日资讯
	private List<DailyNewsCollection> 						imCollection;			//及时通信内容
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<DailyNewsCollection> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<DailyNewsCollection> subjectList) {
		this.subjectList = subjectList;
	}
	public List<DailyNewsCollection> getDailyNewsList() {
		return dailyNewsList;
	}
	public void setDailyNewsList(List<DailyNewsCollection> dailyNewsList) {
		this.dailyNewsList = dailyNewsList;
	}
	public List<DailyNewsCollection> getImCollection() {
		return imCollection;
	}
	public void setImCollection(List<DailyNewsCollection> imCollection) {
		this.imCollection = imCollection;
	}
	
	

	

}
