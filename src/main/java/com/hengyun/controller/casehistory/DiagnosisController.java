package com.hengyun.controller.casehistory;

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
import com.hengyun.service.casehistory.AffiliatedClinicalDiseaseService;
import com.hengyun.service.casehistory.CaseHistoryService;
import com.hengyun.service.casehistory.RiskFactorService;
import com.hengyun.service.casehistory.TargetOrganDamageService;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 下午3:10:12
* 诊断控制器
*/
@Controller
@RequestMapping("diagnosis")
public class DiagnosisController {

	private static final Logger log = LoggerFactory.getLogger(DiagnosisController.class);
	
	@Resource
	private AffiliatedClinicalDiseaseService affiliatedClinicalDiseaseService;
	
	@Resource
	private TargetOrganDamageService targetOrganDamageService;
	
	@Resource
	private RiskFactorService riskFactorService;
	
	@Resource
	private CaseHistoryService caseHistoryService;
	
	 /*
	  * 上传用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(HttpServletRequest request,@RequestParam String data){
		int userId =(int) request.getAttribute("userId");
		
	
		 return JSON.toJSONString(null);
	}
	
	
	 /*
	  * 显示用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String show(){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		

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
