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
	
	private String postID;						//帖子ID
	
	private int 	forumPlate;					//所属板块
	
	private String theme;						//主题
	
	private String author	;						//发帖作者
	
	private Date deliveryTime;				//发帖时间
	
	private String content;						//帖子内容
	
	
	/*
	 * 
	 *  帖子处理
	 * 
	 * */
	
	
	private String status;							//帖子状态(屏蔽，正常)
	
	
	
	private String level;								//帖子等级(置顶，加精)
	
	
	/*
	 *   帖子回复
	 *   
	 * */
	private 				List<PostComment>       commnetList;		//评论列表
	
	
	/*
	 *  帖子统计信息
	 * 
	 * */

	
	private int 			viewCount;				//浏览次数
	
	private int 			replyCount;				//回复次数
	
	private int				supportCount;			//支持次数
	
	private int 			oppositionCount;		//反对次数
	
}
