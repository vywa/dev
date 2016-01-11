package com.hengyun.controller.information;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.GeneralInfo;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  个人基本信息管理
 * */
@Controller
@RequestMapping("info")
public class InfomationController {
	
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private InformationService informationService;
	
	@RequestMapping("imageLoad")
	@ResponseBody
	public String uploadImage(HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String addInfo(@RequestParam String data,HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
		GeneralInfo generalInfo = JSON.toJavaObject(jsonObject, GeneralInfo.class);
		int userId = loginInfoService.isOnline( tocken);
		
		
		ResponseCode response = new ResponseCode();
	
		 if(userId>0){
			 generalInfo.setUserId(String.valueOf(userId));
			 informationService.edit(generalInfo);
			 response.setCode("206");
			 response.setMessage("edit success");
		 } else if(userId<0){
			 response.setCode("109");
			 response.setMessage("user not login");
		 }

		 return JSON.toJSONString(response);
	}
	
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryInfo(HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		return null;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateInfo(@RequestParam String data,HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		return null;
	}
	
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteInfo(HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		
		return null;
	}
	
}
