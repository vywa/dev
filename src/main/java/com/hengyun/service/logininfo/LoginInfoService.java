package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.service.BaseService;

public interface LoginInfoService  extends BaseService<LoginInfo,Integer> {

	public List<LoginInfo> getLoginInfoAll();
	
	//通过用户名密码登陆
	public int loginByUsername(LoginInfo loginInfo,String type);
	//通过tocken登陆
	public boolean loginByTocken(String tocken,LoginInfo loginInfo);
	//通过第三方登陆
	public boolean loginByThirdPart(String tocken,LoginInfo loginInfo);
	
	
	public boolean logout(String tocken);

}
