package com.hengyun.controller.logininfo.mysql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.controller.logininfo.LoginInfoController;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.logininfo.mysql.AccountService;
import com.hengyun.service.logininfo.mysql.LoginService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月2日 上午11:05:24
* 登陆处理器
*/
@Controller
@RequestMapping("login")
public class LoginController {

private static final Logger log = LoggerFactory.getLogger(LoginInfoController.class);
	
	@Resource
	private LoginService loginService;

	@Resource
	private AccountService accountService;
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	@Resource
	private InformationService informationService;
	
	/*
	 * 
	 *  用户名账号登陆
	 *  
	 * */
	@RequestMapping(value="/username",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginByUsername(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);

		String type= jsonObject.getString("type");
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String recordTime = jsonObject.getString("recordTime");
		Date date= null;
		if(recordTime.equals("none")){
			try {
				date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1990-1-1 00:00:00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recordTime = String.valueOf(date.getTime());
		}
		String ip = request.getLocalAddr();
		LoginInfo loginInfo = new LoginInfo();
		UserAccount account = new UserAccount();
		loginInfo.setLoginUsername(username);
		loginInfo.setPassword(password);
		loginInfo.setUserLoginIp(ip);
		LoginResult loginResult;
		try {
			loginResult = loginService.loginByUsername(loginInfo, type);
			if(loginResult!=null){
				System.out.println("用户登陆成功");
			}
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			loginResult = new LoginResult();
			loginResult.setCode("104");
			loginResult.setMessage("login failure");
			return JSON.toJSONString(loginResult);
		}
	
			int userId = loginResult.getUserId();
			 if(userId>0){
			
				 Information information=null;
				try {
					information = informationService.query(userId);
					account = accountService.queryById(userId);
					 long dbRecordTime = Long.valueOf(information.getRecordTime());
					 if(dbRecordTime>Long.valueOf(recordTime)){
						 loginResult.setInfo(information);
						 loginResult.setCode("206");
						 loginResult.setUsername(account.getUsername());
						 
					 } else {
						 loginResult.setCode("207");
						 loginResult.setUsername(account.getUsername());
						 loginResult.setInfo(null);
					 }
				} catch (NullPointerException ex) {
					// TODO Auto-generated catch block
					Information info = new Information();
					info.setUserId(userId);
					info.setRecordTime(String.valueOf(new Date().getTime()));
					informationService.add(info, userId);
					loginResult.setCode("206");
					 loginResult.setInfo(info);
					 loginResult.setUsername(account.getUsername());
				}
				
		}
				return JSON.toJSONString(loginResult);

	}

	/*
	 * 
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
		
		
		if(loginService.loginByTocken(tocken,loginInfo)){
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
		String recordTime = jsonObject.getString("recordTime");
		String username = jsonObject.getString("openId");
		String type= jsonObject.getString("type");
		String userLoginIp = request.getRemoteAddr();
		
		Date date= null;
		if(recordTime.equals("none")){
			try {
				date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1990-1-1 00:00:00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recordTime = String.valueOf(date.getTime());
		}

		LoginInfo loginInfo = new LoginInfo();
		//创建账号
		UserAccount account = new UserAccount();
		loginInfo.setLoginUsername(username);
		loginInfo.setUserLoginIp(userLoginIp);
		LoginResult loginResult = loginService.loginByThirdPart(type, loginInfo);
		int userId = loginResult.getUserId();
		 Information information;
			try {
				information = informationService.query(userId);
				account = accountService.queryById(userId);
				 long dbRecordTime = Long.valueOf(information.getRecordTime());
				 if(dbRecordTime>Long.valueOf(recordTime)){
					 loginResult.setInfo(information);
					 loginResult.setCode("203");
					 loginResult.setUsername(account.getUsername());
				 } else {
					 loginResult.setCode("207");
					 loginResult.setInfo(null);
					 loginResult.setUsername(account.getUsername());
				 }
			} catch (NullPointerException ex) {
				// TODO Auto-generated catch block
				Information info = new Information();
				
				info.setUserId(userId);
				info.setRecordTime(String.valueOf(new Date().getTime()));
				informationService.add(info, userId);
				 loginResult.setUsername(account.getUsername());
				loginResult.setCode("203");
				 loginResult.setInfo(info);
			}
		
	
		return JSON.toJSONString(loginResult);
	}

	/*
	 * 退出登陆
	 * 
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		ResponseCode response = new ResponseCode();
		String tocken = request.getParameter("tocken");
		
		loginService.logout(tocken);
		
		response.setCode("204");
		response.setMessage("logout success");
	
		return  JSON.toJSONString(response);
	}
	
	
	
	/*
	 *  显示所有账号
	 * */
	@RequestMapping("/show")
	@ResponseBody
	public String show() {
		
		List<LoginInfo> loginInfoList ;
		loginInfoList =loginService.getLoginInfoAll();

    	 String jsonString= JSON.toJSONString(loginInfoList);  

        return jsonString;  
	}
}