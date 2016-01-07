package com.hengyun.service.logininfo;

import java.util.List;

import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.service.BaseService;

public interface LoginInfoService  extends BaseService<LoginInfo,Integer> {

	public List<LoginInfo> getLoginInfoAll();
	
	public void login(LoginInfo loginInfo);
	public void logout(String tocken);

}
