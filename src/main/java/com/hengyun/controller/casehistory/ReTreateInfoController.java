package com.hengyun.controller.casehistory;

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
import com.hengyun.domain.casehistory.ReTreateInfo;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.casehistory.ReTreateInfoService;

/*
 * 回访管理
 * */
@Controller
@RequestMapping("retreate")
public class ReTreateInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(ReTreateInfoController.class);
	
	@Resource
	private ReTreateInfoService reTreateInfoService;
	
	/*
	 *  添加回访
	 * */
	@RequestMapping("/add")
	@ResponseBody
	public String addReTreate(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		ReTreateInfo reTreateInfo = JSON.toJavaObject(jsonObject, ReTreateInfo.class);
		reTreateInfoService.addReTreateInfo(reTreateInfo);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("add success");
		 return JSON.toJSONString(response);
	}
	
	
	/*
	 *  添加某个医生的所有回访请求
	 * */
	@RequestMapping("/query")
	@ResponseBody
	public String queryReTreateInfo(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		int docterId = jsonObject.getIntValue("docterId");
		List<ReTreateInfo> reTreateInfoList;
		Query query = Query.query(Criteria.where("docterId").is(docterId));
		reTreateInfoList = reTreateInfoService.queryList(query);

    	 String jsonString= JSON.toJSONString(reTreateInfoList);  
           
    	
        return jsonString;  
	}
	

	
	@RequestMapping("/show")
	@ResponseBody
	public String showAllReTreateInfo(@RequestParam String data,HttpServletRequest request){
		
		List<ReTreateInfo> reTreateInfoList;
		reTreateInfoList = reTreateInfoService.queryAll();

    	 String jsonString= JSON.toJSONString(reTreateInfoList);  
           
    	
        return jsonString;  
	}
	
	/*
	 *  处理回访请求
	 * 
	 * */
	@RequestMapping("/handle")
	@ResponseBody
	public String updateReTreate(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		int docterId = jsonObject.getIntValue("docterId");
		int patientId=jsonObject.getIntValue("patientId");
		String content = "一切正常";
		Query query =Query.query(Criteria.where("docterId").is(docterId).
				andOperator(Criteria.where("patientId").is(patientId).andOperator(Criteria.where("status").is("unhandled"))));
		Update update = Update.update("status", "handled").set("receiveTime", new Date()).set("content", content);
		reTreateInfoService.updateFirst(query, update);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("handle success");
		 return JSON.toJSONString(response);
	}
	
}
