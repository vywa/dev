package com.hengyun.service.friendcircle;

import java.util.List;

import com.hengyun.domain.friendcircle.Friend;
import com.hengyun.domain.friendcircle.FriendCircle;
import com.hengyun.service.BaseService;

//好友处理
public interface FriendCircleService  extends BaseService<FriendCircle,Integer> {

	public List<FriendCircle> queryAll();
	//获取医生列表
	public List<Friend> getDocters(int userId);
	//获取病人列表
	public List<Friend> getPatients(int userId);
	//获取未处理列表
	public List<Friend> getUnhandled(int userId);
	//添加未处理信息
	public void addUnhandled(Friend friend ,int userId);
	//处理未处理信息
	public void handle(Friend friend ,int userId);
	
	//是否在好友列表中
	public int isDocter(int docterId,int patientId);
	//是否是病人
	public int isPatient(int patientId,int docterId);
	
	//是否是好友
	public int isFriend(int request ,int response);
	
	//添加好友
	public void addFriend(Friend friend ,int userId);
	//删除好友
	public void deleteFriend(Friend friend,int userId);
	//设置权限
	public void setFriend(Friend friend, int userId);
}
