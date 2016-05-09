package com.hengyun.service.impl.logininfo.util;

import com.hengyun.domain.information.DoctorInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月9日 下午3:47:54
* 类说明
*/
public class DoctorInfoResponseUtil {

	public static DoctorInfo transfer(DoctorInfo temp){
		DoctorInfo info = new DoctorInfo();
		
		temp.setRecordTime(null);
		
	
		return temp;
	}
}
