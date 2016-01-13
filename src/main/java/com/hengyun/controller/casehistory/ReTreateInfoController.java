package com.hengyun.controller.casehistory;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.ReTreateInfo;
import com.hengyun.domain.common.ResponseCode;

import com.hengyun.service.casehistory.ReTreateInfoService;

/*
 * 回访管理
 * */
@Controller
@RequestMapping("retreate")
public class ReTreateInfoController {
	
	@Resource
	private ReTreateInfoService reTreateInfoService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addReTreate(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		ReTreateInfo reTreateInfo = JSON.toJavaObject(jsonObject, ReTreateInfo.class);
		reTreateInfoService.save(reTreateInfo);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("add success");
		 return JSON.toJSONString(response);
	}
	
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String showAllReTreateInfo(HttpServletRequest request){
		List<ReTreateInfo> reTreateInfoList;
		reTreateInfoList = reTreateInfoService.queryAll();

    	 String jsonString= JSON.toJSONString(reTreateInfoList);  
           
    	
        return jsonString;  
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateCaseHistory(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
}
