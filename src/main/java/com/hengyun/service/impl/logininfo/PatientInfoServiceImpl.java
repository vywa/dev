package com.hengyun.service.impl.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.PatientInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.PatientInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:54:36
* 病人信息业务类
*/
public class PatientInfoServiceImpl extends BaseServiceImpl<PatientInfo,Integer> implements PatientInfoService{

	/*
	 *  获取病人信息
	 * */
	@Override
	public PatientInfo getPatientInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *  病人是否存在
	 * */
	
	@Override
	public int existPatient(String sign, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 *  
	 * */
	@Override
	public List<PatientInfo> getUserAccountALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int registerPatient(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerThirdAccount(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientInfo validateThirdUserBySign(String sign, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
