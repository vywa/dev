package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

/*
 * 
 *  论坛板块
 * */

public class ForumPlate implements Serializable{

	private int			id;										//板块id
	private String forumPlateName;						//板块名称
	private int 		ParentForumPlateId;				//父板块id
	private List<ForumPlate>  childParentForumId;				//子板块列表;
	
	private boolean 	lowestForumPlate;								//是否是最底层板块
	private List<ForumPost>    forumPostList;						//帖子列表
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForumPlateName() {
		return forumPlateName;
	}
	public void setForumPlateName(String forumPlateName) {
		this.forumPlateName = forumPlateName;
	}
	public int getParentForumPlateId() {
		return ParentForumPlateId;
	}
	public void setParentForumPlateId(int parentForumPlateId) {
		ParentForumPlateId = parentForumPlateId;
	}
	public List<ForumPlate> getChildParentForumId() {
		return childParentForumId;
	}
	public void setChildParentForumId(List<ForumPlate> childParentForumId) {
		this.childParentForumId = childParentForumId;
	}
	public boolean isLowestForumPlate() {
		return lowestForumPlate;
	}
	public void setLowestForumPlate(boolean lowestForumPlate) {
		this.lowestForumPlate = lowestForumPlate;
	}
	public List<ForumPost> getForumPostList() {
		return forumPostList;
	}
	public void setForumPostList(List<ForumPost> forumPostList) {
		this.forumPostList = forumPostList;
	}
	
	
	
	
}
