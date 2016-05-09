package com.hengyun.service.impl.logininfo.util;

import com.hengyun.domain.loginInfo.UserAccount;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月9日 下午2:37:14
* 类说明
*/
public class UserAccountResponseUtil {

	public static UserAccount transfer(UserAccount userAccount){
		UserAccount temp = userAccount;
		temp.setPassword(null);
		temp.setCatagory(null);
		temp.setStatus(null);
		return temp;
	}
}
