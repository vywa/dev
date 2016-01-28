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
	private boolean isLiked;					
	private boolean isCollection;		
	private String fileUrl;						
	private int likeCount;
	private String publishTime;
	private int subjectType;
	private String IocInfo;
	private String videoUrl;
	private String soundUrl;
	private String authorPhotoImgUrl;
	
	
	
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
	public String getIocInfo() {
		return IocInfo;
	}
	public void setIocInfo(String iocInfo) {
		IocInfo = iocInfo;
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
