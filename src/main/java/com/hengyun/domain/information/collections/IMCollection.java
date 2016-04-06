package com.hengyun.domain.information.collections;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月6日 下午2:04:32
* 及时通信收藏
*/
public class IMCollection implements Serializable{

	private List<String>			contents;								//内容
	private Date collectionTime;											//收藏时间
	
	
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	public Date getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}
	
	
}
