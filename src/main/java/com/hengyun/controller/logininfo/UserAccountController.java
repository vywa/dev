package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.loginInfo.RegisterResult;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.loginInfo.constant.UserCatagory;
import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.logininfo.UserAccountService;
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
	

/*
 *  注册账号
 * */	
	
	
	//短信发送
	@RequestMapping("/smsSend")
	@ResponseBody
	public String smsSend(@RequestParam String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String mobilephone = jsonObject.getString("phonenumber");
		
		//查询改手机号是否注册
		
		if(userAccountService.existUserAccountBySign(mobilephone)){
			return "exist";
		} else {
			if(registerCacheService.getTryCount(mobilephone)<6){
				//随机生成六位数，并更新到缓存
				registerCacheService.setConfirmCode(mobilephone, "666666");
				registerCacheService.addTryCount(mobilephone);
				SubmitResult result;
				SmsSender sms = new SmsSender(mobilephone,666666);
				result =  sms.send();
				if(result!=null){
					if(result.getCode()==2){
						return "ok";
					}
				} else {
					return "failure";
				}
			} else {
				return "too many time";
			}
		}
		
		return "failure";
	
		
	}
	

    //短信接收注册
	@RequestMapping("/smsReceive")
	@ResponseBody
	public String smsReceive(@RequestParam String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String mobilephone = jsonObject.getString("phonenumber");
		String confirmCode = jsonObject.getString("code");
		String password =  jsonObject.getString("password");
		UserCatagory userCatagory = (UserCatagory)jsonObject.get("UserCatagory");
		RegisterResult registResult = new RegisterResult();
		
		if(registerCacheService.getConfirmCode(mobilephone).equals(confirmCode)){
			UserAccount userAccount = new UserAccount();
			userAccount.setMobilephone(mobilephone);
			userAccount.setPassword(password);
			userAccount.setUserCatagory(userCatagory);
			int id = userAccountService.registerAccount(userAccount);
			registResult.setCode("0");
			registResult.setMessage("id");
			
		} else {
			registerCacheService.addTryCount(mobilephone);
			registResult.setCode("2");
			registResult.setMessage("验证码错误");
		}
		
	
		return "registersuccess";
	}
	
	
	
	//邮箱发送验证码
	@RequestMapping("/mailSend")
	@ResponseBody
	public String mailSend(HttpServletRequest request,Model model){
		
		
	
		return "registersuccess";
	}
	
	
	   //邮箱接收注册
		@RequestMapping("/mailReceive")
		@ResponseBody
		public String mailReceive(HttpServletRequest request,Model model){
			
			
		
			return "registersuccess";
		}
	

    /*
     *  查询账号
     * */
    @ResponseBody  
    @RequestMapping("/showAllAccount") 
    public  String   findUserAccount(){
    	List<UserAccount> userAccountList ;
    	userAccountList = userAccountService.getUserAccountALL();

    	 String jsonString= JSON.toJSONString(userAccountList);  
           
    	
        return jsonString;  
    }
    
    
    
    /*
     *  变更账号
     * 
     * */
    
    @ResponseBody  
    @RequestMapping("/change") 
    public  String  changeUserAccount(){
    	
    	
        return "change";
    }
}
