package com.hengyun.controller.hospital;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.hospital.Docter;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.service.hospital.DocterService;

/*
 *  医生管理
 * 
 * */
@Controller
@RequestMapping("docter")
public class DoctorController {
	
	@Resource 
	private DocterService docterService;
	
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
	
	
	
	@RequestMapping("/show")
	@ResponseBody
	public String showDocter(HttpServletRequest request){
		List<Docter> docterList ;
		docterList = docterService.queryAll();

    	 String jsonString= JSON.toJSONString(docterList);  
        return jsonString;  
	}
	
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
