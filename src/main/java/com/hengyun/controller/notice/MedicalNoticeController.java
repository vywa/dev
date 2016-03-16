package com.hengyun.controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.loginInfo.RegisterResult;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午6:10:10
* 医疗通知控制器
*/
@Controller
@RequestMapping("mnotice")
public class MedicalNoticeController {

	/*
	 * 查询医生所有病人通知
	 * 
	 * */
	@RequestMapping(value="/smsSend",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String smsSend(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		
		String mobilephone = jsonObject.getString("mobilephone");
		RegisterResult registResult = new RegisterResult();
		//查询改手机号是否注册
	
		
		return JSON.toJSONString(registResult);
	
		
	}
}
