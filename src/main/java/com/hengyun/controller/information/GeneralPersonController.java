package com.hengyun.controller.information;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.dao.information.IconDao;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.GeneralPerson;
import com.hengyun.service.information.GeneralPersonService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  个人基本信息管理
 * */
@Controller
@RequestMapping("person")
public class GeneralPersonController {
	
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private InformationService informationService;
	@Resource
	private IconDao	IconDao;
	
	@Resource
	private GeneralPersonService generalPersonService;
	
	  
	   
	//添加用户信息
	@RequestMapping("/add")
	@ResponseBody
	public String addPerson(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		GeneralPerson generalPerson = JSON.toJavaObject(jsonObject, GeneralPerson.class);
		ResponseCode response = new ResponseCode();
	
		generalPersonService.save(generalPerson);
			 response.setCode("206");
			 response.setMessage("edit success");
		
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String show(){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		List<GeneralPerson> generalPerson = generalPersonService.queryList(query);
		 return JSON.toJSONString(generalPerson);
	}
	

	
}
