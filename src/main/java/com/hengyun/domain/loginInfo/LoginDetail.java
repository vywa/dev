package com.hengyun.domain.loginInfo;

import java.util.Date;

import com.hengyun.domain.loginInfo.constant.LoginChannel;
import com.hengyun.domain.loginInfo.constant.LoginModel;
import com.hengyun.domain.loginInfo.constant.LoginStatus;
import com.hengyun.domain.loginInfo.constant.UserCatagory;

/*
 *  用户登陆明细
 *  
 * */

public class LoginDetail {

	private LoginModel loginModel; 				//用户登陆方式（会员，第三方,手机动态登陆）
	private LoginChannel loginChannel;			//用户登陆通道（手机，pad，网站等）
	private String loginUsername;						//用户登陆名（手机号，邮箱，账号，第三方账号,动态随机用户名）
	private String mobilephone;							//用户手机
	private String password;							 		//用户登陆密码
	private UserCatagory catagory;						//用户类型
	private double longitude;								//登陆经度
	private double latitude;									//登陆纬度
	private String userLoginIp;											//登陆ip
	private Date userLoginTime;									//登陆时间
	private Date userLogoutTime;								//退出时间
	private  LoginStatus loginStatus ;					//用户登陆状态(登陆，未登录)
	private String 				sessionid;					//登陆会话id
	

	public LoginModel getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
	public LoginChannel getLoginChannel() {
		return loginChannel;
	}
	public void setLoginChannel(LoginChannel loginChannel) {
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
	public UserCatagory getCatagory() {
		return catagory;
	}
	public void setCatagory(UserCatagory catagory) {
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
	public LoginStatus getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	
}
