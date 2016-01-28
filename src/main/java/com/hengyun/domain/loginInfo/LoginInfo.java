package com.hengyun.domain.loginInfo;

import java.io.Serializable;
import java.util.Date;

/*
 *  用户登陆基本信息
 * */

public class LoginInfo implements Serializable{

	
	private int userId;												//用户ID
	private String loginModel; 				//用户登陆方式（会员，第三方,手机动态登陆）
	private String loginChannel;			//用户登陆通道（手机，pad，网站等）
	private String loginUsername;						//用户登陆名（手机号，邮箱，账号，第三方账号,动态随机用户名）
	private String mobilephone;							//用户手机
	private String password;							 		//用户登陆密码
	private String catagory;						//用户类型
	private double longitude;								//登陆经度
	private double latitude;									//登陆纬度
	private String userLoginIp;											//登陆ip
	private Date userLoginTime;									//登陆时间
	private Date userLogoutTime;								//退出时间
	private  String loginStatus ;					//用户登陆状态(登陆，未登录)
	private String 				sessionid;					//登陆会话id
	private int			loginCount;										//在线数量
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(String loginModel) {
		this.loginModel = loginModel;
	}
	public String getLoginChannel() {
		return loginChannel;
	}
	public void setLoginChannel(String loginChannel) {
		this.loginChannel = loginChannel;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getUserLoginIp() {
		return userLoginIp;
	}
	public void setUserLoginIp(String userLoginIp) {
		this.userLoginIp = userLoginIp;
	}
	public Date getUserLoginTime() {
		return userLoginTime;
	}
	public void setUserLoginTime(Date userLoginTime) {
		this.userLoginTime = userLoginTime;
	}
	public Date getUserLogoutTime() {
		return userLogoutTime;
	}
	public void setUserLogoutTime(Date userLogoutTime) {
		this.userLogoutTime = userLogoutTime;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	


}

