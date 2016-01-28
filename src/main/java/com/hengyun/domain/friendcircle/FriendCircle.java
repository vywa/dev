package com.hengyun.domain.friendcircle;

import java.io.Serializable;
import java.util.List;


/*
 * 
 *   朋友圈
 * */
public class FriendCircle implements Serializable{

	private int userId;											//圈子主人id
	
	private List<Friend> allFriendsList;			//朋友列表
	
	private List<Friend> docters;						//医生列表
	
	private List<Friend> patients;						//病人列表
	
	
	
	private List<Friend> friendList;		//好友列表
	
	private List<Friend>  unhandlerFriendList;			//请求好友列表
	
	private List<FriendGroup>  dropFriendList;						//删除好友列表
	
	private List<FriendGroup>  maybeFamilarList;				//可能熟悉的人

	
	
	public List<Friend> getAllFriendsList() {
		return allFriendsList;
	}

	public void setAllFriendsList(List<Friend> allFriendsList) {
		this.allFriendsList = allFriendsList;
	}

	public List<Friend> getDocters() {
		return docters;
	}

	public void setDocters(List<Friend> docters) {
		this.docters = docters;
	}

	public List<Friend> getPatients() {
		return patients;
	}

	public void setPatients(List<Friend> patients) {
		this.patients = patients;
	}



	public List<Friend> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Friend> getUnhandlerFriendList() {
		return unhandlerFriendList;
	}

	public void setUnhandlerFriendList(List<Friend> unhandlerFriendList) {
		this.unhandlerFriendList = unhandlerFriendList;
	}

	public List<FriendGroup> getDropFriendList() {
		return dropFriendList;
	}

	public void setDropFriendList(List<FriendGroup> dropFriendList) {
		this.dropFriendList = dropFriendList;
	}

	public List<FriendGroup> getMaybeFamilarList() {
		return maybeFamilarList;
	}

	public void setMaybeFamilarList(List<FriendGroup> maybeFamilarList) {
		this.maybeFamilarList = maybeFamilarList;
	}
	
	

	
}
