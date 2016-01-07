package com.hengyun.domain.forum;

import java.util.List;

/*
 * 
 *  论坛板块
 * */

public class ForumPlate {

	private int			forumId;										//板块id
	private String forumPlateName;						//板块名称
	private int 		ParentForumPlateId;				//父板块id
	private List<ForumPlate>  childParentForumId;				//子板块列表;
	
	private boolean 	lowestForumPlate;								//是否是最底层板块
	private List<ForumPost>    forumPostList;						//帖子列表
	
	
	
}
