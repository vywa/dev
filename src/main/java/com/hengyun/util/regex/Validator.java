package com.hengyun.util.regex;

import java.util.regex.Pattern;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月22日 上午10:08:56
* 判断用户名类型:手机，邮箱，用户名
*/
public class Validator {

	//验证邮箱
	public static final String REGEX_EMAIL="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	//验证用户名
	public static final  String REGEX_USERNAME="^[a-zA-Z0-9_-]{3,15}$";
	//验证手机号
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	//验证密码
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,15}$";
	
	/**
     * 校验用户名
     * 
     * @param username
     * @return 校验通过返回true，否则返回false
     */
	public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }
	
	/**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
	public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
	
	 /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
	 public static boolean isMobile(String mobile) {
	        return Pattern.matches(REGEX_MOBILE, mobile);
	    }
	 
	 /**
	     * 校验密码
	     * 
	     * @param password
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isPassword(String password) {
	        return Pattern.matches(REGEX_PASSWORD, password);
	    }
	    
	    /*
	     *  获取类型
	     * */
	    public static String type(String username){
	    	if(isMobile(username)) return "mobilephone";
	    	else if(isEmail(username)) return "email";
	    	else if(isUsername(username)) return "username";
	    	else return "unknown";
	    }
}
