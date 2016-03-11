package com.hengyun.service.friendcircle.mysql;

import java.util.List;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午1:34:59
* 好友类
*/
public interface RosterService {

	public List<Integer> getFriendList(String username);
}
