package com.hengyun.controller.hospital;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.hospital.Docter;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.hospital.DocterService;

/*
 *  医生管理
 * 
 * */
@Controller
@RequestMapping("docter")
public class DocterController {
	
	private static final Logger log = LoggerFactory.getLogger(DocterController.class);
	
	@Resource 
	private DocterService docterService;
	
	/*
	 *  添加医生
	 *  
	 * */
	@RequestMapping("/add")
	@ResponseBody
	public String addHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Docter docter = JSON.toJavaObject(jsonObject, Docter.class);
		docterService.save(docter);
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("edit success");
		 return JSON.toJSONString(response);
	}
	
	
	@RequestMapping(value="/queryDoctor",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showHospitalDocter(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		int hospitalId = jsonObject.getIntValue("hospitalId");
		List<UserAccount> docterList ;
		docterList = docterService.queryByHospital(hospitalId);
    	 String jsonString= JSON.toJSONString(docterList);  
        return jsonString;  
	}
	
	/*
	 *  查询某个医院的医生
	 * */
	@RequestMapping("/show")
	@ResponseBody
	public String showDocter(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		int hospitalId = jsonObject.getIntValue("hospitalId");
		
		List<Docter> docterList ;
		docterList = docterService.queryAll();

    	 String jsonString= JSON.toJSONString(docterList);  
        return jsonString;  
	}
	
	/*
	 *  查询某个工号医生信息
	 *  
	 * */
	@RequestMapping("/query")
	@ResponseBody
	public String queryDocter(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String workNum = jsonObject.getString("workNum");
		Query query = Query.query(Criteria.where("workNum").is(workNum));
		Docter docter = docterService.queryOne(query);
		return  JSON.toJSONString(docter);  
	}
	
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editHospital(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteDocter(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String workNum = jsonObject.getString("workNum");
		Query query = Query.query(Criteria.where("workNum").is(workNum));
	
		return "delete docter sucess";
	}
	
	
}
