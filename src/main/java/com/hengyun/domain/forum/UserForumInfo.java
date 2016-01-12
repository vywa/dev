package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.Privilege;
import com.hengyun.domain.friendcircle.FriendCircle;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.notice.Notice;

/*
 *  用户的论坛相关信息
 * */
public class UserForumInfo implements Serializable{

	/*
	 * 
	 *  论坛用户基本信息
	 * */
	private int id;																		//用户ｉｄ
	
	private ForumGeneralInfo	forumGeneralInfo;			//用户论坛基本信息
	
	
	/*
	 *  登陆信息,活跃状况
	 * */
	private ForumLoginInfo	forumLoginInfo;							//论坛登陆信息
	
	/*
	 *   论坛权限信息
	 * 
	 * */
	private List<Privilege> previlege;									//用户权限列表
	
	/*
	 * 帖子管理
	 * */
	private List<ForumPost> forumPosts;						//帖子管理
	
	

	/*
	 *  论坛统计信息
	 * */
	
	private StatisticInfo		statisticInfo;					//统计信息
	
	
	/*
	 *  好友管理
	 * */
	
	private FriendCircle friendCircle;							//好友圈子
	
	
	
	
	/*
	 *  消息管理
	 * 
	 * */
	private List<Notice> noticeList;									//消息列表
	
	
	/*
	 *  积分管理
	 * */
	private List<Integral>		integral;							//积分信息
	
	
	/*
	 * 收藏管理
	 * */
	
	private List<String> talkList;								//我的说说
	
	private List<String> shareList;							//我的分享
	
	private List<String> praiseList;							//我的点赞
	
	private List<String> transferList;						//我的转发
	
	
	
	
}
