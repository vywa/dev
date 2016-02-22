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
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.service.hospital.HospitalService;

/*
 *  医生管理
 * 
 * */
@Controller
@RequestMapping("hospital")
public class HospitalController {
	
	@Resource 
	private HospitalService hospitalService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Hospital hospital = JSON.toJavaObject(jsonObject, Hospital.class);
		hospitalService.save(hospital);
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("edit success");
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Hospital hospital = JSON.toJavaObject(jsonObject, Hospital.class);
		Query query = Query.query(Criteria.where("id").is(hospital.getId()));
		Update update = Update.update("hospitalName",hospital.getHospitalName()).set("email", hospital.getEmail()).
				set("hospitalIM", hospital.getHospitalIM()).set("level", hospital.getLevel()).set("telephone", hospital.getTelephone()).
				set("address", hospital.getAddress()).set("weiChatNumber", hospital.getWeiChatNumber());
		hospitalService.updateInser(query, update);
	//	hospitalService.save(hospital);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("update success");
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setHospital(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping(value="/showAll",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryHospital(HttpServletRequest request){
		List<Hospital> hospitalList ;
		int id =(int)request.getAttribute("userId");
		System.out.println("用户id是："+id);
    	hospitalList = hospitalService.queryAll();

    	 String jsonString= JSON.toJSONString(hospitalList);  
        return jsonString;  
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		int id = jsonObject.getIntValue("id");
		Hospital hospital = hospitalService.queryById(id);
		return  JSON.toJSONString(hospital);  
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editHospital(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		int id = jsonObject.getIntValue("id");
		hospitalService.deleteById(id);
		return "delete hospital sucess";
	}
	
	
}
