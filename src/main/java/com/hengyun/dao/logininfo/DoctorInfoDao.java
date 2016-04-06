package com.hengyun.dao.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.DoctorInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:42:58
* 医生信息数据访问接口
*/
public interface DoctorInfoDao{

	public int addDoctor(DoctorInfo doctorInfo) ;
	
	public boolean updateDoctor(DoctorInfo doctorInfo);
	
	public DoctorInfo queryOne(DoctorInfo doctorInfo);
	
	public List<DoctorInfo> query(DoctorInfo doctorInfo);
	
}
