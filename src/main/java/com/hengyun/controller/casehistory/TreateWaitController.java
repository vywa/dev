package com.hengyun.controller.casehistory;

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
import com.hengyun.domain.casehistory.TreateWait;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.TreateWaitService;

/*
 * 就诊管理
 * 
 * */
@Controller
@RequestMapping("treate")
public class TreateWaitController {
	
	private static final Logger log = LoggerFactory.getLogger(TreateWaitController.class);
	
	@Resource
	private TreateWaitService treateWaitService;
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String addTreateWait(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		TreateWait TreateWait = JSON.toJavaObject(jsonObject, TreateWait.class);
		treateWaitService.save(TreateWait);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("add success");
		 return JSON.toJSONString(response);
	}
	
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String showAllReTreateInfo(HttpServletRequest request){
		List<TreateWait> treateWaitList;
		treateWaitList = treateWaitService.queryAll();

    	 String jsonString= JSON.toJSONString(treateWaitList);  
        return jsonString;  
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateCaseHistory(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
}
