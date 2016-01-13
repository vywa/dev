package com.hengyun.controller.hospital;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.domain.hospital.Office;
import com.hengyun.service.hospital.OfficeService;

/*
 *  科室管理
 * 
 * */
@Controller
@RequestMapping("office")
public class OfficeController {
	
	@Resource 
	private OfficeService officeService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addOffice(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Office office = JSON.toJavaObject(jsonObject, Office.class);
		officeService.save(office);
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("edit success");
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/addDocter")
	@ResponseBody
	public String addDocter(HttpServletRequest request){
		String idStr = request.getParameter("docterId");
		String officeId = request.getParameter("officeId");
		officeService.addDocter(Integer.valueOf(idStr), Integer.valueOf(officeId));
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("edit success");
		 return JSON.toJSONString(response);
				
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setHospital(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/showAll")
	@ResponseBody
	public String queryOffice(HttpServletRequest request){
		List<Office> office ;
    	office = officeService.queryAll();

    	 String jsonString= JSON.toJSONString(office);  
        return jsonString;  
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editHospital(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	
}
