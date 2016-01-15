package com.hengyun.domain.information;


import java.io.Serializable;

/*
 *  通用功能的人
 * */


public  class GeneralPerson implements Serializable{
	
	private int id;																//用户id
	
	
	
	private int	 informationId;							//个人基本信息
	
	private int 	userAccountId;							//个人账号信息
	
	private int		loginInfoId;									//用户登陆信息	
	
	private int		userForumInfoId;					//用户论坛信息
	
	private int		friendCircleId;								//朋友圈
	
	private int				noticeId;										//通知信息
	
	
	
	private int	shoppingId;									//用户购物信息



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getInformationId() {
		return informationId;
	}



	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}



	public int getUserAccountId() {
		return userAccountId;
	}



	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}



	public int getLoginInfoId() {
		return loginInfoId;
	}



	public void setLoginInfoId(int loginInfoId) {
		this.loginInfoId = loginInfoId;
	}



	public int getUserForumInfoId() {
		return userForumInfoId;
	}



	public void setUserForumInfoId(int userForumInfoId) {
		this.userForumInfoId = userForumInfoId;
	}



	public int getFriendCircleId() {
		return friendCircleId;
	}



	public void setFriendCircleId(int friendCircleId) {
		this.friendCircleId = friendCircleId;
	}



	public int getNoticeId() {
		return noticeId;
	}



	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}



	public int getShoppingId() {
		return shoppingId;
	}



	public void setShoppingId(int shoppingId) {
		this.shoppingId = shoppingId;
	}
	
	
	
	
}
