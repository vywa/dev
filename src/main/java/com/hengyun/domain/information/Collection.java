package com.hengyun.domain.information;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:07:19
* 收藏类
*/
public class Collection implements Serializable{

	private int id;									//收藏id
	private int userId;							//用户id
	

	private String url;						//资源url
	
	
	private Date collectionTime;		//收藏时间


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


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
