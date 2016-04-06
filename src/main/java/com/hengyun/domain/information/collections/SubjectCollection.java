package com.hengyun.domain.information.collections;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月6日 下午2:00:04
* 帖子收藏
*/
public class SubjectCollection implements Serializable{

	private String url;											//收藏地址
	private Date collectionTime;						//收藏时间
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}
	
	
	
}
