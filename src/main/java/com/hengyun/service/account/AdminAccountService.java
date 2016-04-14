package com.hengyun.service.account;

import java.util.List;

import com.hengyun.domain.account.AdminInfo;
import com.hengyun.domain.account.DoctorInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午2:40:10
* 管理员业务类
*/
public interface AdminAccountService extends BaseService<AdminInfo,Integer>{

	//查询管理员信息
	public AdminInfo getAdminInfoById(int id);
	
	//用户是否存在
	public int existAdmin(String sign,String type);
	
	//注册账号
	public int registerAdmin(String username,String type,String password);
	
	//验证用户是否有效,返回用户userId
	public LoginResult validateUserBySign(String sign, String type,String password) ;
	
	//更改密码
	public void updatePassword(String password,int userId) ;
	
	//更改密码
	public int change(String type,String username,int userId);
	
	//获取所有管理员账号
	public List<AdminInfo> getUserAccountALL();
	
	
}
