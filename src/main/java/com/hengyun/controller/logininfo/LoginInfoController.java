package com.hengyun.controller.logininfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.DoctorInfo;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.loginInfo.response.DoctorLoginResponse;
import com.hengyun.service.casehistory.CaseHistoryService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;
import com.hengyun.util.randomcode.TockenGenerator;
import com.hengyun.util.regex.Validator;

@Controller
@RequestMapping("reglog")
public class LoginInfoController {

	private static final Logger log = LoggerFactory.getLogger(LoginInfoController.class);
	
	@Resource
	private LoginInfoService loginInfoService;

	@Resource
	private UserAccountService userAccountService;
	
	@Resource
	private LoginInfoCacheService loginInfoCacheService;
	
	@Resource
	private InformationService informationService;
	
	@Resource
	private CaseHistoryService caseHistoryService;
	
	/*
	 *  用户名账号登陆
	 * */
	
	@RequestMapping(value="/username",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginByUsername(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);

		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String recordTime = jsonObject.getString("recordTime");
		String type=Validator.type(username);
	
		
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
			loginResult = loginInfoService.loginByUsername(loginInfo, type);
			if(loginResult!=null){
				System.out.println("用户登陆成功");
			}
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			loginResult = new LoginResult();
			loginResult.setCode("104");
			loginResult.setMessage("登陆失败");
			return JSON.toJSONString(loginResult);
		}
	
			int userId = loginResult.getUserId();
			
			 if(userId>0){
				 String userIdStr = String.valueOf(userId);
				 //医生端
		 if(userIdStr.startsWith("20")){
				 Information information=null;
				 UserAccount account3 = userAccountService.getUserAccountById(userId);
				try {
					information = informationService.query(userId);
					
					information.setEmail(account3.getEmail());
					information.setMobilephone(account3.getMobilephone());
					information.setQQ(account3.getQQ());
					information.setWeiBo(account3.getWeiBo());
					information.setWeiChat(account3.getWeiChat());
					information.setUsername(account3.getUsername());
					
		
					 long dbRecordTime = Long.valueOf(information.getRecordTime());
					 int caseHistoryId = caseHistoryService.getPatientLatest(userId);
					 if(caseHistoryId<0) {
						 loginResult.setQuestionaire(false);
					 } else {
						 loginResult.setQuestionaire(true);
					 }
					 if(dbRecordTime>Long.valueOf(recordTime)){
						 loginResult.setInfo(information);
						 loginResult.setCode("206");
						
						 
					 } else {
						 loginResult.setCode("207");
					
						 loginResult.setInfo(null);
					 }
				} catch (NullPointerException ex) {
					// TODO Auto-generated catch block
					Information info = new Information();
					info.setUserId(userId);
					info.setRecordTime(String.valueOf(new Date().getTime()));
				
			
					info.setEmail(account3.getEmail());
					info.setMobilephone(account3.getMobilephone());
					info.setQQ(account3.getQQ());
					info.setWeiBo(account3.getWeiBo());
					info.setWeiChat(account3.getWeiChat());
					info.setUsername(account3.getUsername());
					
					
					
					informationService.add(info, userId);
					loginResult.setCode("206");
					 loginResult.setInfo(info);
				
				}
				 }
		}
				return JSON.toJSONString(loginResult);

	}
	
	/*
	 *  用户名账号登陆
	 * */
	
	@RequestMapping(value="doctor/username",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorLogin(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);

		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");

		String type=Validator.type(username);
		DoctorLoginResponse response = new DoctorLoginResponse();
		int userId = loginInfoService.doctorLogin(username, type, password);
		if(userId<0){
			response.setCode("104");
			response.setMessage("登陆失败");
		} else {
			response.setCode("206");
			response.setMessage("登陆成功");
			response.setUserId(userId);
			String tocken = TockenGenerator.generate(username+userId+new Date().toString());
			String old = loginInfoCacheService.getTockenById(userId);
			loginInfoCacheService.loginByTocken(tocken, userId, old);
			response.setTocken(tocken);
		}
		
		return JSON.toJSONString(response);
		
				 
		
	}
	
	
	/*
	 * 病人端登陆
	 * */
	@RequestMapping(value="patient/username",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String patientLogin(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String recordTime = jsonObject.getString("recordTime");
		String type=Validator.type(username);
		
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
			loginResult = loginInfoService.loginByUsername(loginInfo, type);
			if(loginResult!=null){
				System.out.println("用户登陆成功");
			}
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			loginResult = new LoginResult();
			loginResult.setCode("104");
			loginResult.setMessage("登陆失败");
			return JSON.toJSONString(loginResult);
		}
	
			int userId = loginResult.getUserId();
			
			 if(userId>0){
				 String userIdStr = String.valueOf(userId);
				 //医生端
			
				 Information information=null;
				
				try {
					information = informationService.query(userId);
				
					UserAccount account3 = userAccountService.getUserAccountById(userId);
					information.setEmail(account3.getEmail());
					information.setMobilephone(account3.getMobilephone());
					information.setQQ(account3.getQQ());
					information.setWeiBo(account3.getWeiBo());
					information.setWeiChat(account3.getWeiChat());
					
					 long dbRecordTime = Long.valueOf(information.getRecordTime());
					 int caseHistoryId = caseHistoryService.getPatientLatest(userId);
					 if(caseHistoryId<0) {
						 loginResult.setQuestionaire(false);
					 } else {
						 loginResult.setQuestionaire(true);
					 }
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
				
				//	Information information2 = informationService.query(userId);
					
					UserAccount account3 = userAccountService.getUserAccountById(userId);
					info.setEmail(account3.getEmail());
					info.setMobilephone(account3.getMobilephone());
					info.setQQ(account3.getQQ());
					info.setWeiBo(account3.getWeiBo());
					info.setWeiChat(account3.getWeiChat());
					informationService.add(info, userId);
					loginResult.setCode("206");
					 loginResult.setInfo(info);
					 loginResult.setUsername(account.getUsername());
				}
			
		} 
				return JSON.toJSONString(loginResult);
		
				 
		
	}
	
	/*
	 * 验证tocken有效性
	 * 
	 */
	@RequestMapping(value="/fresh",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String freshToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
		String tocken = request.getParameter("tocken");
	
		LoginInfo loginInfo = new LoginInfo();
		int status = loginInfoCacheService.isOnline(tocken);
		
		if(status>0){
			registResult.setCode("206");
			registResult.setMessage("令牌有效");
		} else  {
			registResult.setCode("106");
			registResult.setMessage("令牌失效");
		}
		return JSON.toJSONString(registResult);
}

	/*
	 * 通过存储tocken登陆
	 * 
	 */
	@RequestMapping(value="/auto",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginByTocken(HttpServletRequest request) {
		// TODO Auto-generated method stub
	//	JSONObject jsonObject =JSON.parseObject(data);
		RegisterResult registResult = new RegisterResult();
	//	String tocken = jsonObject.getString("tocken");
	//	String type= jsonObject.getString("type");
		String tocken = request.getParameter("tocken");
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
	@RequestMapping(value="/thirdPart",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginByThirdPart(@RequestParam String data,HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONObject jsonObject =JSON.parseObject(data);
		String recordTime = jsonObject.getString("recordTime");
		String thirdname = jsonObject.getString("openId");
		String type= jsonObject.getString("type");
		String nickName = jsonObject.getString("nickName");
	
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

		loginInfo.setLoginUsername(thirdname);
		loginInfo.setUserLoginIp(userLoginIp);
		//三方登陆
		LoginResult loginResult = loginInfoService.loginByThirdPart(type, loginInfo,nickName);
		
		int userId = loginResult.getUserId();
		 Information information;
		 account = userAccountService.queryById(userId);
			try {
				information = informationService.query(userId);
				
				 long dbRecordTime = Long.valueOf(information.getRecordTime());
				 int caseHistoryId = caseHistoryService.getPatientLatest(userId);
				 if(caseHistoryId<0) {
					 loginResult.setQuestionaire(false);
				 } else {
					 loginResult.setQuestionaire(true);
				 }
				 if(dbRecordTime>Long.valueOf(recordTime)){
					 loginResult.setInfo(information);
					 loginResult.setCode("203");
					
				 } else {
					 loginResult.setCode("207");
					 loginResult.setInfo(null);
				
				 }
				 Query query = Query.query(Criteria.where("userId").is(userId));
				 Update update=new Update();
				 switch(type){
					case "QQ":
						information.setQqName(nickName); 
						update= update.set("qqName", nickName);
						break;
					case "weiBo":
						information.setWeiboName(nickName);
						update= update.set("weiBo", nickName);
						break;
					case "weiChat":
						information.setWeiChatName(nickName);
						update= update.set("weiChat", nickName);
						break;
					default :break;
					}
				informationService.updateFirst(query, update);;
				information.setEmail(account.getEmail());
				information.setMobilephone(account.getMobilephone());
				information.setUsername(account.getUsername());
				
				
				loginResult.setInfo(information);
			} catch (NullPointerException ex) {
				// TODO Auto-generated catch block
				Information info = new Information();
				switch(type){
				case "QQ":
					info.setQqName(nickName);
					break;
				case "weiBo":
					info.setWeiboName(nickName);
					break;
				case "weiChat":
					info.setWeiChatName(nickName);
					break;
				default :break;
				}
				info.setUserId(userId);
				info.setRecordTime(String.valueOf(new Date().getTime()));
				informationService.add(info, userId);
				info.setUsername(account.getUsername());
				info.setEmail(account.getEmail());
				info.setMobilephone(account.getMobilephone());
				loginResult.setCode("203");
				loginResult.setInfo(info);
			}
	
		return JSON.toJSONString(loginResult);
	}

	/*
	 * 退出登陆
	 * 
	 */
	@RequestMapping(value="/logout",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		ResponseCode response = new ResponseCode();
		String tocken = request.getParameter("tocken");
		
		loginInfoCacheService.destroyCache(tocken);
		
		response.setCode("204");
		response.setMessage("退出成功");
	
		return  JSON.toJSONString(response);
	}
	
	/*
	 * 退出登陆
	 * 
	 */
	@RequestMapping(value="/mail",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String mail(HttpServletRequest request) {
		
		ResponseCode response = new ResponseCode();
		String email = request.getParameter("email");
	
		response.setCode("204");
		response.setMessage("用户"+email+"注册成功");
	
		return  JSON.toJSONString(response);
	}
	
	/*
	 *  显示所有账号
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String show() {
		
		List<LoginInfo> loginInfoList ;
		loginInfoList =loginInfoService.getLoginInfoAll();

    	 String jsonString= JSON.toJSONString(loginInfoList);  
           
    	
        return jsonString;  
	}
}
