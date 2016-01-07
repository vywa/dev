package com.hengyun.domain.friendcircle;

import java.util.List;

import com.hengyun.domain.common.GeneralPerson;


/*
 * 
 *   朋友圈
 * */
public class FriendCircle {

	private List<Friend> allFriendsList;			//朋友列表
	
	private List<FriendGroup> friendGroup;		//好友分组
	
	private List<FriendGroup>  unhandlerFriendList;			//请求好友列表
	
	private List<FriendGroup>  dropFriendList;						//删除好友列表
	
	private List<FriendGroup>  maybeFamilarList;				//可能熟悉的人
	
	

	
}
