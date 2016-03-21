package com.hengyun.domain.information;

import java.io.Serializable;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月21日 上午10:37:20
*医生基本信息返回类
*/
public class DoctorInfoResponse extends ResponseCode  implements Serializable{

	private DoctorInfo doctorInfo ;

	public DoctorInfo getDoctorInfo() {
		return doctorInfo;
	}

	public void setDoctorInfo(DoctorInfo doctorInfo) {
		this.doctorInfo = doctorInfo;
	}
	
	
}
