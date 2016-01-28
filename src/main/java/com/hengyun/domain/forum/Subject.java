package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 	论坛帖子信息
 * */
public class Subject implements Serializable {
	
	private String content;						//帖子内容
	private List<String> imgUrls;			//图片地址
	private String author;						//作者
	private String title;								//标题
	private int replyNum;						//回复数
	private int subjectId;						//帖子
	private boolean isLiked;					//是否被我赞过
	private boolean isCollection;		//是否被我收藏过
	private String fileUrl;							//附件url
	private int likeCount;						//被多少人赞过
	private String publishTime;				//发帖时间
	private int subjectType;					//帖子类型
	private String locInfo;							//具体的定位信息
	private String videoUrl;						//视频地址
	private String soundUrl;					//声音地址
	private String authorPhotoImgUrl;				//作者图像
	private double lng;							//定位的经度
	private double lat;							//定位的纬度
	
	
	
	
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	public boolean isCollection() {
		return isCollection;
	}
	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}

	
	
	public String getLocInfo() {
		return locInfo;
	}
	public void setLocInfo(String locInfo) {
		this.locInfo = locInfo;
	}
	public String getSoundUrl() {
		return soundUrl;
	}
	public void setSoundUrl(String soundUrl) {
		this.soundUrl = soundUrl;
	}
	public String getAuthorPhotoImgUrl() {
		return authorPhotoImgUrl;
	}
	public void setAuthorPhotoImgUrl(String authorPhotoImgUrl) {
		this.authorPhotoImgUrl = authorPhotoImgUrl;
	}
	
	
}
