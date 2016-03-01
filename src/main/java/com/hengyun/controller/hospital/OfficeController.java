package com.hengyun.controller.hospital;

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
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.hospital.Office;
import com.hengyun.service.hospital.OfficeService;

/*
 *  科室管理
 * 
 * */
@Controller
@RequestMapping("office")
public class OfficeController {
	
	private static final Logger log = LoggerFactory.getLogger(OfficeController.class);
	
	
	@Resource 
	private OfficeService officeService;
	
	/*
	 *  添加科室
	 * */
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
	
	/*
	 *  科室添加医生
	 * */
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
	
	/*
	 *  更新科室信息
	 * */
	@RequestMapping("/update")
	@ResponseBody
	public String updateOfficel(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Office office = JSON.toJavaObject(jsonObject, Office.class);
		Query query = Query.query(Criteria.where("officeId").is(office.getOfficeId()));
		Update update = Update.update("hospitalId", office.getHospitalId()).set("officeName", office.getOfficeName()).set("description", office.getDescription());
		officeService.updateFirst(query, update);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("edit success");
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showOffice(HttpServletRequest request){
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
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryOffice(HttpServletRequest request){
		String idStr =  request.getParameter("officeId");
		Query query = Query.query(Criteria.where("officeId").is(Integer.valueOf(idStr)));
		Office office = officeService.queryOne(query);
		return  JSON.toJSONString(office);  
	}
	
}
