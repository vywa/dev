package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.loginInfo.constant.UserCatagory;
import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.logininfo.UserAccountService;
import com.hengyun.util.mail.SimpleMail;
import com.hengyun.util.sms.SubmitResult;
import com.hengyun.util.sms.sender.SmsSender;


/*
 *  用户账号管理，包括注册账号，修改账号等操作
 * */

@Controller
@RequestMapping("account")
public class UserAccountController {

	@Resource
	private UserAccountService userAccountService;
	
	@Resource
	private RegisterCacheService registerCacheService;
	
	@Resource
	private  SimpleMail simpleMail;
/*
 *  注册账号
 * */	
	
	
	//短信发送
	@RequestMapping("/smsSend")
	@ResponseBody
	public String smsSend(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		
		String mobilephone = jsonObject.getString("mobilephone");
		RegisterResult registResult = new RegisterResult();
		//查询改手机号是否注册
		
		if(userAccountService.existUserAccountBySign(mobilephone,"mobilephone")){
			registResult.setCode("102");
			registResult.setMessage("user exist");
		} else {
			if(registerCacheService.getTryCount(mobilephone)<6){
			int codeNum = (int)(Math.random()*1000000);
				codeNum = codeNum>100000?codeNum:codeNum+100000;
				registerCacheService.setConfirmCode(mobilephone, String.valueOf(codeNum));
				registerCacheService.addTryCount(mobilephone);
				
				SubmitResult result;
				SmsSender sms = new SmsSender(mobilephone,codeNum);
				result =  sms.send();
				if(result!=null){
					if(result.getCode()==2){
						registResult.setCode("205");
						registResult.setMessage("test code send success");
					}
				} else {
					registResult.setCode("101");
					registResult.setMessage("test code send fail");
				}
			} else {
				registResult.setCode("106");
				registResult.setMessage("too many time");
			}
		}
		
		return JSON.toJSONString(registResult);
	
		
	}
	

    //短信接收注册
	@RequestMapping("/smsReceive")
	@ResponseBody
	public String smsReceive(@RequestParam String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String mobilephone = jsonObject.getString("mobilephone");
		String confirmCode = jsonObject.getString("code");
		String password =  jsonObject.getString("password");
		
		RegisterResult registResult = new RegisterResult();
		
		if(registerCacheService.getConfirmCode(mobilephone).equals(confirmCode)){
			UserAccount userAccount = new UserAccount();
			userAccount.setMobilephone(mobilephone);
			userAccount.setPassword(password);
			userAccount.setCatagory("patient");
			int id = userAccountService.registerAccount(userAccount);
			registerCacheService.updateRegisterCache(userAccount.getMobilephone());
			registResult.setCode("205");
			registResult.setMessage(String.valueOf(id));
			
		} else {
			registerCacheService.addTryCount(mobilephone);
			registResult.setCode("107");
			registResult.setMessage("test code error");
		}
		
	
		return JSON.toJSONString(registResult);
	}
	
	
	
	//邮箱发送验证码
	@RequestMapping("/mailSend")
	@ResponseBody
	public String mailSend(@RequestParam String data){
		
		JSONObject jsonObject =JSON.parseObject(data);
		
		String email = jsonObject.getString("email");
		RegisterResult registResult = new RegisterResult();
		//查询改邮箱是否注册
		
		if(userAccountService.existUserAccountBySign(email,"email")){
			registResult.setCode("102");
			registResult.setMessage("user exist");
		} else {
		
				int codeNum = (int)(Math.random()*1000000);
				codeNum = codeNum>100000?codeNum:codeNum+100000;
				registerCacheService.setConfirmCode(email, String.valueOf(codeNum));
				registerCacheService.addTryCount(email);
				String subject = "天衡会员确认邮件";
				String content = "您本次验证码是"+codeNum+"如果非本人操作，请忽略。";
				String to = email;
				simpleMail.sendMail( subject,  content,  to);
				
				
				registResult.setCode("205");
				registResult.setMessage("test code send success");
			
		}
		
		return JSON.toJSONString(registResult);
	
	}
	
	
	   //邮箱接收注册
		@RequestMapping("/mailReceive")
		@ResponseBody
		public String mailReceive(@RequestParam String data){

			JSONObject jsonObject = JSONObject.parseObject(data);
			String email = jsonObject.getString("email");
			String confirmCode = jsonObject.getString("code");
			String password =  jsonObject.getString("password");
			
			RegisterResult registResult = new RegisterResult();
			
			if(registerCacheService.getConfirmCode(email).equals(confirmCode)){
				UserAccount userAccount = new UserAccount();
				userAccount.setEmail(email);
				userAccount.setPassword(password);
				userAccount.setCatagory("patient");
				int id = userAccountService.registerAccount(userAccount);
				registerCacheService.updateRegisterCache(userAccount.getEmail());
				registResult.setCode("201");
				registResult.setMessage(String.valueOf(id));
				
			} else {
				
				registResult.setCode("107");
				registResult.setMessage("code error");
			}
			
		
			return JSON.toJSONString(registResult);
		}
	

		/*
		 * 
		 * 医生注册
		 * 
		 * */
		
		@RequestMapping("/register")
		@ResponseBody
		public String docterRegister(@RequestParam String data){
			JSONObject jsonObject = JSONObject.parseObject(data);
			ResponseCode response = new ResponseCode();
			UserAccount account = JSON.toJavaObject(jsonObject, UserAccount.class);
			String username = jsonObject.getString("workNum");
			
			if(userAccountService.existUserAccountBySign(username,"workNum")){
				response.setCode("102");
				response.setMessage("user exist");
			} else{
			int id = userAccountService.registerAccount(account);
			response.setCode("201");
			response.setMessage(String.valueOf(id));
			}
			 return JSON.toJSONString(response);
		}
		
    /*
     *  查询账号
     * */
   
    @RequestMapping("/show") 
    @ResponseBody  
    public  String   findUserAccount(){
    	List<UserAccount> userAccountList ;
    	userAccountList = userAccountService.getUserAccountALL();

    	 String jsonString= JSON.toJSONString(userAccountList);  
           
    	
        return jsonString;  
    }
    
    
    /*
     *  修改密码
     * */
 
    @RequestMapping("/findPassword") 
    @ResponseBody  
    public  String   findPassword(@RequestParam String data){
    	
    	JSONObject jsonObject =JSON.parseObject(data);
		String mobilephone = jsonObject.getString("mobilephone");
		RegisterResult registResult = new RegisterResult();
		
		if(!userAccountService.existUserAccountBySign(mobilephone,"mobilephone")){
			registResult.setCode("103");
			registResult.setMessage("user not exist");
		} else {
		
			int codeNum = (int)(Math.random()*1000000);
				codeNum = codeNum>100000?codeNum:codeNum+100000;
				registerCacheService.setConfirmCode(mobilephone, String.valueOf(codeNum));
			
				
				SubmitResult result;
				SmsSender sms = new SmsSender(mobilephone,codeNum);
				result =  sms.send();
				if(result!=null){
					if(result.getCode()==2){
						registResult.setCode("205");
						registResult.setMessage("test code send success");
					}
				} else {
					registResult.setCode("101");
					registResult.setMessage("test code send failure");
				}
		
		}
		
		return JSON.toJSONString(registResult);
	
		
    }
    
    
    /*
     *  变更账号
     * 
     * */
    
    @ResponseBody  
    @RequestMapping("/updatePassword") 
    public  String  changeUserAccount(@RequestParam String data){
    	
    	JSONObject jsonObject = JSONObject.parseObject(data);
		String mobilephone = jsonObject.getString("mobilephone");
		String confirmCode = jsonObject.getString("code");
		String password =  jsonObject.getString("password");
	
		RegisterResult registResult = new RegisterResult();
		
		if(registerCacheService.getConfirmCode(mobilephone).equals(confirmCode)){
			UserAccount userAccount = new UserAccount();
			userAccount.setMobilephone(mobilephone);
			userAccount.setPassword(password);
			
			 userAccountService.updateUserAccount(userAccount);
			registResult.setCode("206");
			registResult.setMessage("password update success");
			
		} else {
			registerCacheService.addTryCount(mobilephone);
			registResult.setCode("107");
			registResult.setMessage("test code error");
		}
		
	
		return JSON.toJSONString(registResult);
       
    }
}
