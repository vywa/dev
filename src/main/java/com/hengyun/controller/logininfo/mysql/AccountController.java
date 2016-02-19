package com.hengyun.controller.logininfo.mysql;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.message.ProducerEmailServiceImpl;
import com.hengyun.service.impl.message.ProducerSmsServiceImpl;
import com.hengyun.service.logininfo.mysql.AccountService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月19日 上午8:47:02
* 用户账号管理
*/

@Controller
@RequestMapping("account")
public class AccountController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Resource
	private AccountService accountService;
	
	@Resource
	private ProducerEmailServiceImpl producerEmailServiceImpl;
	
	@Resource
	private ProducerSmsServiceImpl producerSmsServiceImpl;
	
	
		//发送短信邮箱验证码
		@RequestMapping(value="/sendCode",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String test(@RequestParam String data){
			JSONObject jsonObject =JSON.parseObject(data);
			String type = jsonObject.getString("type");
			if(type.equals("mobilephone")){
				String mobilephone = jsonObject.getString("username");
				producerSmsServiceImpl.sendSms(mobilephone);
			}
			else if(type.equals("email")){
				String email = jsonObject.getString("username");
				producerEmailServiceImpl.sendEmail(email);
			}
			RegisterResult registResult = new RegisterResult();
			registResult.setCode("205");
			registResult.setMessage("验证码发送成功");
			return  JSON.toJSONString(registResult);
		}
	
		
		//手机注册
		@RequestMapping(value="/mobileRegister",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String mobileRegister(@RequestParam String data){
			JSONObject jsonObject = JSONObject.parseObject(data);
			String mobilephone = jsonObject.getString("mobilephone");
			
			String password =  jsonObject.getString("password");
			
			RegisterResult registResult = new RegisterResult();
				UserAccount userAccount = new UserAccount();
				
				userAccount.setMobilephone(mobilephone);
				userAccount.setPassword(password);
				userAccount.setCatagory("patient");
				if(accountService.exsitUser(mobilephone, "mobilephone")){
					registResult.setCode("102");
					registResult.setMessage("用户已经注册");
					
				} else {
				int id = accountService.add(userAccount);
				
				registResult.setCode("205");
				registResult.setMessage(String.valueOf(id));
				}
			return JSON.toJSONString(registResult);
		}

		
		//邮箱注册
		@RequestMapping(value="/emailRegister",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String emailRegister(@RequestParam String data){
			JSONObject jsonObject = JSONObject.parseObject(data);
			String email = jsonObject.getString("email");
			String password =  jsonObject.getString("password");
			
			RegisterResult registResult = new RegisterResult();
			UserAccount userAccount = new UserAccount();
				
				userAccount.setEmail(email);
				userAccount.setPassword(password);
				userAccount.setCatagory("patient");
				
				if(accountService.exsitUser(email, "email")){
					registResult.setCode("102");
					registResult.setMessage("用户已经注册");
				} else {
				int id = accountService.add(userAccount);
				
				registResult.setCode("205");
				registResult.setMessage(String.valueOf(id));
				}
				
			return JSON.toJSONString(registResult);
		}
	
		
		   /*
	     *  查询所有账号
	     * */
	   
	    @RequestMapping("/showAccount") 
	    @ResponseBody  
	    public  String   findUserAccount(){
	    	List<UserAccount> userAccountList ;
	    	userAccountList = accountService.showAll();

	    	 String jsonString= JSON.toJSONString(userAccountList);  
	        return jsonString;  
	    }
	    
	    //查询userId用户信息
	    @RequestMapping("/queryId") 
	    @ResponseBody  
	    public  String   queryAccount(@RequestParam String data){
	    	JSONObject jsonObject =JSON.parseObject(data);
	    	int id = jsonObject.getIntValue("id");
	    	UserAccount userAccount =null;
	    	String jsonString= null;
	    	try {
				userAccount=accountService.queryById(id);
				if(userAccount != null){
					jsonString= JSON.toJSONString(userAccount);  	    
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.debug(id+" 对应的用户不存在");
			}

	        return jsonString;  
	    }
	    
	    
	    //
}
