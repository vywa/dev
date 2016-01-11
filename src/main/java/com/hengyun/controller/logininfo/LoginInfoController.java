package com.hengyun.controller.logininfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.logininfo.LoginInfoService;

@Controller
@RequestMapping("reglog")
public class LoginInfoController {

	@Resource
	private LoginInfoService loginInfoService;

	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	@RequestMapping("/username")
	@ResponseBody
	public String loginByUsername(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
		
		String type= jsonObject.getString("type");
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String ip = request.getLocalAddr();
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoginUsername(username);
		loginInfo.setPassword(password);
		loginInfo.setUserLoginIp(ip);
		String loginFlag = loginInfoService.loginByUsername(loginInfo, type);
		if(!loginFlag.equals("failure")){
			registResult.setCode("202");
			registResult.setMessage(loginFlag);
		}else {
			registResult.setCode("104");
			registResult.setMessage("login failure");
		}

		return JSON.toJSONString(registResult);
	}

	/*
	 * 通过存储tocken登陆
	 * 
	 */
	@RequestMapping("/auto")
	@ResponseBody
	public String loginByTocken(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
		String tocken = jsonObject.getString("tocken");
		String type= jsonObject.getString("type");
		LoginInfo loginInfo = new LoginInfo();
		
		
		if(loginInfoService.loginByTocken(tocken,loginInfo)){
			registResult.setCode("206");
			registResult.setMessage("登陆成功");
		} else  {
			registResult.setCode("106");
			registResult.setMessage("登陆失败");
		}
		return JSON.toJSONString(registResult);
}
	
	

	/*
	 * 通过第三方登陆
	 * 
	 */
	@RequestMapping("/thirdPart")
	@ResponseBody
	public String loginByThirdPart(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
		
	
		String username = jsonObject.getString("openId");
		String type= jsonObject.getString("type");
		String userLoginIp = request.getRemoteAddr();
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoginUsername(username);
		loginInfo.setUserLoginIp(userLoginIp);
		String tocken = loginInfoService.loginByThirdPart(type, loginInfo);
		
		registResult.setCode("203");
		registResult.setMessage(tocken);
		return JSON.toJSONString(registResult);
	}

	/*
	 * 退出登陆
	 * 
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(@RequestParam String data) {
		JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
		String tocken = jsonObject.getString("tocken");
		
		loginInfoService.logout(tocken);
		registResult.setCode("204");
		registResult.setMessage("logout success");
	
		return  JSON.toJSONString(registResult);
	}
}
