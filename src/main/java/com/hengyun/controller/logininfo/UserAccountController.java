package com.hengyun.controller.logininfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.logininfo.UserAccountService;


/*
 *  用户账号管理，包括注册账号，修改账号等操作
 * */

@Controller
@RequestMapping("account")
public class UserAccountController {

	@Resource
	private UserAccountService userAccountService;
	

/*
 *  注册账号
 * */	
	@RequestMapping("/register")
	@ResponseBody
	public String login(HttpServletRequest request,Model model){
		
		
	
		return "registersuccess";
	}
	

    
    
    /*
     *  查询账号
     * */
    @ResponseBody  
    @RequestMapping("/showAll") 
    public  String   findUserAccount(){
    	List<UserAccount> userAccountList ;
    	userAccountList = userAccountService.getUserAccountALL();

    	 String jsonString= JSON.toJSONString(userAccountList);  
           
    	
        return jsonString;  
    }
}
