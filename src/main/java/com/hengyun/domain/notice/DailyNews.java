package com.hengyun.domain.notice;

import java.io.Serializable;
import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 下午2:18:49
* 每日推送
*/
public class DailyNews implements Serializable{

	private int id;																		//咨讯id
	private String imageUrl;													//图片url
	private String content;														//内容快照
	private String url;																//内容url
	private List<String> imagesUrl;										//图片url
	
	
	
	public List<String> getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(List<String> imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
