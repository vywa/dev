package com.hengyun.controller.casehistory;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.casehistory.AffiliatedClinicalDisease;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.casehistory.CaseHistoryConstant;
import com.hengyun.domain.casehistory.Diagnosis;
import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;
import com.hengyun.domain.casehistory.RiskFactor;
import com.hengyun.domain.casehistory.TargetOrganDamage;
import com.hengyun.domain.casehistory.response.CaseHistoryResponse;
import com.hengyun.domain.casehistory.response.CaseHistoryResponseCode;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.domain.notice.Notice.noticeType;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.service.casehistory.AffiliatedClinicalDiseaseService;
import com.hengyun.service.casehistory.CaseHistoryService;
import com.hengyun.service.casehistory.DiagnosisService;
import com.hengyun.service.casehistory.RiskFactorService;
import com.hengyun.service.casehistory.TargetOrganDamageService;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.notice.MedicalNoticeService;
import com.hengyun.service.patient.BloodPressureInfoService;


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
	
	@Resource
	private RosterService rosterService;
	
	@Resource
	private BloodPressureInfoService bloodPressureInfoService;
	
	@Resource
	private DiagnosisService diagnosisService;
	
	@Resource
	private InformationService informationService;
	
	@Resource
	private MedicalNoticeService medicalNoticeService;
	 /*
	  * 上传用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(HttpServletRequest request,@RequestParam String data){
		
		int userId =(int) request.getAttribute("userId");
		JSONObject jsonObject = JSON.parseObject(data);
		JSONArray[] array = new JSONArray[3];
		 array[0] = JSONArray.parseArray(jsonObject.getString("danger"));
		 array[1] = JSONArray.parseArray(jsonObject.getString("damage"));
		 array[2] = JSONArray.parseArray(jsonObject.getString("disease"));
		RiskFactor riskFactor = new RiskFactor();
		riskFactor.setHightBloodPressure(bloodPressureInfoService.getLevel(userId));
		riskFactor.setAge(informationService.query(userId).getAge());
		AffiliatedClinicalDisease affiliatedClinicalDisease = new AffiliatedClinicalDisease();
		TargetOrganDamage targetOrganDamage = new TargetOrganDamage();
		int temp=0;
	
		for(int i=0;i<array.length;i++){
			
		for(int j=0;j<array[i].size();j++){
			temp=array[i].getIntValue(j)-1;
			if(temp<0){
				continue;
			}
			try {
				if(i==0){
					Field field = RiskFactor.class.getDeclaredField(CaseHistoryConstant.danger[temp]);
					field.setAccessible(true);
					field.setBoolean(riskFactor, true);
				} else if(i==1){
					Field field = TargetOrganDamage.class.getDeclaredField(CaseHistoryConstant.damage[temp]);
					field.setAccessible(true);
					field.setBoolean(targetOrganDamage, true);
				} else if(i==2){
					
					Field field = AffiliatedClinicalDisease.class.getDeclaredField(CaseHistoryConstant.disease[temp]);
					field.setAccessible(true);
					field.setBoolean(affiliatedClinicalDisease, true);
				}
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
		
		int doctorId = rosterService.getDoctor(String.valueOf(userId));
		CaseHistory caseHistory = new CaseHistory();
		caseHistory.setPatientId(userId);
		caseHistory.setDocterId(doctorId);
		caseHistory.setDiagnosisTime(new Date());
		//生成病历
		int caseId = caseHistoryService.addCaseHistory(caseHistory);
		Query query = Query.query(Criteria.where("caseHistoryId").is(caseId));
		Update update = Update.update("riskFactor", riskFactor).
				set("targetOrganDamage", targetOrganDamage).set("affiliatedClinicalDisease", affiliatedClinicalDisease);
		
		caseHistoryService.updateFirst(query, update);
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("上传成功");
		 return JSON.toJSONString(response);
	}
	
	
	 /*
	  * 
	  * 显示用户自己的诊断信息
	  * 
	  * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request){
		int userId =(int) request.getAttribute("userId");
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		
		List<CaseHistory> caseList = caseHistoryService.queryList(query);
		CaseHistoryResponse response = new CaseHistoryResponse();
		response.setCode("206");
		response.setMessage("查询诊断结果成功");
		response.setCaseHistoryList(caseList);
		 return JSON.toJSONString(response);
	}
	
	 /*
	  * 
	  * 病人亲属查询用户自己的诊断信息
	  * 
	  * */
	@RequestMapping(value="/friendQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String friendQuery(HttpServletRequest request){
		int userId =(int) request.getAttribute("userId");
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		
		List<CaseHistory> caseList = caseHistoryService.queryList(query);
		CaseHistoryResponse response = new CaseHistoryResponse();
		response.setCode("206");
		response.setMessage("查询诊断结果成功");
		response.setCaseHistoryList(caseList);
		 return JSON.toJSONString(response);
	}
	
	 /*
	  * 
	  * 查询某个用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String show(HttpServletRequest request,@RequestParam String data){
		JSONObject jsonObject = JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		
		List<CaseHistory> caseList = caseHistoryService.queryList(query);
		CaseHistoryResponse response = new CaseHistoryResponse();
		response.setCode("206");
		response.setMessage("查询诊断结果成功");
		response.setCaseHistoryList(caseList);
		 return JSON.toJSONString(response);
	}
	
	 /*
	  * 
	  * 查询某个用户诊断信息
	  * 
	  * */
	@RequestMapping(value="/result",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String result(HttpServletRequest request){
	
		int patientId =(int) request.getAttribute("userId");
		CaseHistoryResponseCode response = new CaseHistoryResponseCode();
		//获取病人最近时间的病历
		int caseHistoryId = caseHistoryService.getPatientLatest(patientId);
		log.info("用户最近一次的病历号为 "+caseHistoryId);
		if(caseHistoryId<0){
			//查询用户是否有上传血压
			List<BloodPressureInfo> list = bloodPressureInfoService.getlatestTime(patientId);
			if(list == null){
				response.setCode("111");
				response.setMessage("用户没有录入血糖和血压");
				return  JSON.toJSONString(response);
			}
			response.setCode("112");
			response.setMessage("用户没有录入健康因素");
			return  JSON.toJSONString(response);
		}
		Query query = new Query();
		query.addCriteria(Criteria.where("caseHistoryId").is(caseHistoryId));
		CaseHistory caseHistory = caseHistoryService.query(caseHistoryId);
		int patient = caseHistory.getPatientId();
		int doctor = caseHistory.getDocterId();
		String diagContent="未知" ;
		DangerLevel dangerLevel = diagnosisService.assess(caseHistoryId);
		log.info("用户最近一次的病历号为 "+dangerLevel);
		
		switch(dangerLevel){
		case not_danger: diagContent="正常";break;
		case little_danger: diagContent="低危";break;
		case moderate_danger: diagContent="中危";
		case more_danger: diagContent="高危";
		case most_danger: diagContent="极高危";
		//向医生发送危险通知
				MedicalNotice mn = new MedicalNotice();
				mn.setContent("用户诊断结果危险等级为: "+diagContent);
				mn.setDangerLevel(dangerLevel);
				mn.setNoticeFromId(doctor);
				mn.setNoticeToId(patient);
				mn.setSendTime(new Date());
				mn.setType(noticeType.medical_notice);
				//诊断通知
				mn.setNoticeType(1);
				medicalNoticeService.addNotice(mn);
				break;
		}
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setDangerLevel(dangerLevel);
		diagnosis.setRecordDate(new Date());
		List<String> content = new ArrayList<String>();
		content.add("用户诊断结果危险等级为: "+diagContent);
		diagnosis.setCotent(content);
		//更新用户病历
		Update update = Update.update("diagnosis", diagnosis);
		caseHistoryService.updateFirst(query, update);
		log.info("添加一条病历");
		
		//查询病历
		CaseHistory caseHistory2 = caseHistoryService.query(caseHistoryId);
		
		
		response.setCode("206");
		response.setMessage("查询诊断结果成功");
		response.setCaseHistory(caseHistory2);
		 return JSON.toJSONString(response);
	}
	
	
}
