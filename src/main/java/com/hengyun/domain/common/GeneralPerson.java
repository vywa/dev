package com.hengyun.domain.common;


import com.hengyun.domain.forum.UserForumInfo;
import com.hengyun.domain.friendcircle.FriendCircle;
import com.hengyun.domain.location.Location;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.notice.Notice;
import com.hengyun.domain.shopping.Shopping;

/*
 *  通用功能的人
 * */


public  class GeneralPerson {
	
	private int ID;																//用户id
	
	private GeneralInfo	generalInfo;							//个人基本信息
	
	private UserAccount	userAccount;							//个人账号信息
	
	private LoginInfo		loginInfo;									//用户登陆信息	
	
	private UserForumInfo			userForumInfo;					//用户论坛信息
	
	private FriendCircle		friendCircle;								//朋友圈
	
	private Notice				notice;										//通知信息
	
	
	
	private Shopping	shopping;									//用户购物信息
	
	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}
	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	public UserForumInfo getUserForumInfo() {
		return userForumInfo;
	}
	public void setUserForumInfo(UserForumInfo userForumInfo) {
		this.userForumInfo = userForumInfo;
	}
	public FriendCircle getFriendCircle() {
		return friendCircle;
	}
	public void setFriendCircle(FriendCircle friendCircle) {
		this.friendCircle = friendCircle;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public Shopping getShopping() {
		return shopping;
	}
	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}

	
}
