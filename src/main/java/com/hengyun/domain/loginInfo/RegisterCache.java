package com.hengyun.domain.loginInfo;

/*
 *  注册缓存
 *  以手机号码和邮箱为标示
 * 
 * */
public class RegisterCache {

	private String sign;					//用户手机号或邮箱

	
	private int		tryCount;								//用户注册尝试次数(<=5)
	private String confirmCode;					//验证码
	private String status;									//是否注册
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getTryCount() {
		return tryCount;
	}
	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}
	public String getConfirmCode() {
		return confirmCode;
	}
	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
