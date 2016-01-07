package com.hengyun.domain.friendcircle;

import java.util.List;

import com.hengyun.domain.common.Privilege;

/*
 *  朋友信息
 * 
 * */
public class Friend {

	private int 		friendId;					//朋友ID
	private String friendName;				//朋友名称
	
	private String loginStatus;							//登陆状态
	
	private List<Privilege> privilegeList;			//对朋友权限列表
	
}
