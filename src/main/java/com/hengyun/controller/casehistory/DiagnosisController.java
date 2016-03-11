package com.hengyun.controller.casehistory;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 下午3:10:12
* 诊断控制器
*/
@Controller
@RequestMapping("diagnosis")
public class DiagnosisController {

	 /*
	  * 显示用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String show(){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		
	//	List<Information> information = informationService.getPage(query, 0, 3);
		 return JSON.toJSONString(null);
	}
	
	 /*
	  * 显示用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String update(){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		//List<Information> information = informationService.queryList(query);
	//	List<Information> information = informationService.getPage(query, 0, 3);
		 return JSON.toJSONString(null);
	}
}
