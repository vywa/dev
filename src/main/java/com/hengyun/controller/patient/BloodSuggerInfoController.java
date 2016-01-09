package com.hengyun.controller.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.domain.patient.HealthInfoResponse;
import com.hengyun.service.patient.BloodSuggerInfoService;

/*
 * 
 *  血糖操作
 * */
@Controller
@RequestMapping("bloodSugger")
public class BloodSuggerInfoController {

	@Resource
	private BloodSuggerInfoService  bloodSuggerInfoService;
	
	
	@RequestMapping("/showLog")
	@ResponseBody
	public String showBlood(@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		
		int userId = jsonObject.getInteger("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodSuggerInfo> bloodList = bloodSuggerInfoService.getInfoByTime(startTime, endTime, userId);
		System.out.println(bloodList);
		String result = JSONObject.toJSONString(bloodList);
		return result;
	}
	
	@RequestMapping("/showAll")
	@ResponseBody
	public String showBlood(){
		Query query = Query.query(Criteria.where("userId").exists(true));
		
		List<BloodSuggerInfo> list =bloodSuggerInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	
	//上传数据
	@RequestMapping("/upload")
	@ResponseBody
	public String  upload(@RequestParam String data){
		
		JSONObject jsonObject =JSON.parseObject(data);
		
		int userId = jsonObject.getInteger("userId");
		long date = jsonObject.getLongValue("measureTime");
	    
	//     SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	   //  sdf.format(new Date(date));
		//Date measureTime = new Date(date);
		double bsValue = jsonObject.getDoubleValue("bsValue");
		int measureType = jsonObject.getIntValue("measureType");
		
		
	
		
		HealthInfoResponse response = new HealthInfoResponse();
		BloodSuggerInfo sugger = new BloodSuggerInfo();
		sugger.setIuserId(userId);
		sugger.setBsValue(bsValue);
		sugger.setMeasureTime(date);
		sugger.setMeasureType(measureType);

		//保存数据
		bloodSuggerInfoService.save(sugger);
		response.setCode("0");
		response.setMessage("record success");
		String result = JSON.toJSONString(response);
		return result;
		
	}
}
