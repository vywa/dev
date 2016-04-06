package com.hengyun.domain.information;

import java.io.Serializable;
import java.util.Date;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月6日 下午2:02:21
* 资讯收藏
*/
public class DailyNewsCollection implements Serializable{

	private int id;											//收藏id
	private String url;									//链接地址
	private Date collectionTime;				//收藏时间
	private int type;										//收藏类型（帖子０，资讯１，及时通信２）
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
