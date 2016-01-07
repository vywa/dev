package com.hengyun.domain.friendcircle;

import java.util.List;

import com.hengyun.domain.common.Privilege;

/*
 * 好友分组
 * */
public class FriendGroup {

	private String groupName;											//朋友组名称
	
	private List<Friend>	friendList;								//组内朋友列表
	
	private Privilege 	privilege;											//组内权限
	
	private String 	status;													//组状态
}
