package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.SubjectAvailableList;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 上午10:59:06
* 朋友圈权限控制业务接口　
*/
public interface SubjectAvailableListService extends BaseService<SubjectAvailableList,Integer>{

	//更新朋友圈 可见列表
	public int updateAvailable(SubjectAvailableList subjectAvailableList);
	
	//更新朋友圈关注列表
	public int updateSubscribe(SubjectAvailableList subjectAvailableList);
	
	//查询某个人的可见好友列表
	public List<Integer> queryAvailable(int userId);
	
	//查询某个人关注列表
	public List<Integer> querySubscribe(int userId);
	
	//初始化某个人的权限列表
	public void init(int userId);
}
