package com.hengyun.dao.friendcircle.mysql;

import java.util.List;

import com.hengyun.domain.friendcircle.Roster;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午12:00:13
*用户花名册数据接口
*/
public interface RosterDao {

	public List<Roster> getRoster(String username);
	
	
}
