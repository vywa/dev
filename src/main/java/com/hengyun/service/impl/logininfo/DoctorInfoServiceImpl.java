package com.hengyun.service.impl.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.DoctorInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.DoctorInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:54:18
* 医生信息业务类
*/
public class DoctorInfoServiceImpl  extends BaseServiceImpl<DoctorInfo,Integer> implements DoctorInfoService{

	@Override
	public DoctorInfo getDoctorInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int existDoctor(String sign, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DoctorInfo> getUserAccountALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int registerDoctor(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorInfo validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
