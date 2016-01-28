package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 	论坛帖子信息
 * */
public class ForumPost implements Serializable {

	/*
	 *  帖子信息
	 * 
	 * 
	 * */
	
	private int id;										//帖子ID
	
	private int 	forumPlateId;					//所属板块
	
	private String theme;						//主题
	
	private int subjectType;					//问题类型 0一般，１精华，２我发出，３收藏
	
	private int userId	;							//发帖作者
	
	private Date deliveryTime;				//发帖时间
	
	private String content;						//帖子内容
	
	private String title;								//帖子标题
	
	
	/*
	 * 
	 *  帖子处理
	 * 
	 * */
	
	
	private String status;							//帖子状态(屏蔽，正常)
	
	
	
	public int getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}

	private String level;								//帖子等级(置顶，加精)
	
	
	/*
	 *   帖子回复
	 *   
	 * */
	private 				List<Integer>       commnetList;		//评论列表
	
	
	/*
	 *  帖子统计信息
	 * 
	 * */

	
	private int 			viewCount;				//浏览次数
	
	private int 			replyCount;				//回复次数
	
	private int				supportCount;			//支持次数
	
	private int 			oppositionCount;		//反对次数

	



	public List<Integer> getCommnetList() {
		return commnetList;
	}

	public void setCommnetList(List<Integer> commnetList) {
		this.commnetList = commnetList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getForumPlateId() {
		return forumPlateId;
	}

	public void setForumPlateId(int forumPlateId) {
		this.forumPlateId = forumPlateId;
	}



	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(int supportCount) {
		this.supportCount = supportCount;
	}

	public int getOppositionCount() {
		return oppositionCount;
	}

	public void setOppositionCount(int oppositionCount) {
		this.oppositionCount = oppositionCount;
	}
	
	
	
}
