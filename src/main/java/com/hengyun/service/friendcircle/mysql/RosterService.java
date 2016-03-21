package com.hengyun.service.friendcircle.mysql;

import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午1:34:59
* 好友类
*/
public interface RosterService {

	public int getDoctor(String username);
	
	public List<Integer> getFriendList(String username);
	
	public List<Integer> searchFriendList(String username,String searchName);
	
	//查询两个人是否是好友
	public boolean makeFriend(String person1,String person2);
}
