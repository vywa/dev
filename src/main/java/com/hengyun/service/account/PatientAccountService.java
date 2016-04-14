package com.hengyun.service.account;

import java.util.List;

import com.hengyun.domain.account.PatientInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.BaseService;
import com.hengyun.service.impl.account.UserNotExistException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:51:43
* 病人信息业务接口
*/
public interface PatientAccountService extends BaseService<PatientInfo,Integer>{

	public PatientInfo getPatientInfoById(int id) ;
	
	
	//用户是否存在
	public int existPatient(String sign, String type);
	
	public List<PatientInfo> getUserAccountALL();
	
	//更改密码
	public void updatePassword(String password,int userId) ;

	//注册账号
	public int registerPatient(String username,String type,String password);
	
	//改变用户找好绑定信息
	public int change(String type,String username,int userId);
	
	//第三方登陆注册
	public int registerThirdAccount(String sign,String type);
	
	//验证用户是否有效,返回用户userId
	public LoginResult validateUserBySign(String sign, String type,String password) ;
	
	
	
}
