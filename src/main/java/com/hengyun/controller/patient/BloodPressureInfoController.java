package com.hengyun.controller.patient;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.domain.patient.HealthInfoResponse;
import com.hengyun.domain.patient.PressureResponse;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.patient.BloodPressureInfoService;

/*
 * 
 *  血压操作
 * */
@Controller
@RequestMapping("bloodPressure")
public class BloodPressureInfoController {

	@Resource
	private BloodPressureInfoService  bloodPressureInfoService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	@RequestMapping("/show")
	@ResponseBody
	public String showBlood(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		PressureResponse response = new PressureResponse();
		String tocken = request.getParameter("tocken");
		
		int userId = loginInfoService.isOnline(tocken);
		
		if(userId<0){
			response.setCode("112");
			response.setBloodPressureInfo(null);
		} else {
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId);
			
		
		response.setCode("211");
		response.setBloodPressureInfo(bloodList);
		}
		return  JSONObject.toJSONString(response);
	}
	
	@RequestMapping("/latestDay")
	@ResponseBody
	public String lates(HttpServletRequest request){
	
		PressureResponse response = new PressureResponse();
		String tocken = request.getParameter("tocken");
		
		int userId = loginInfoService.isOnline(tocken);
		
		if(userId<0){
			response.setCode("112");
			response.setBloodPressureInfo(null);
		} else {
			
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getlatestTime(userId);

		response.setCode("211");
		response.setBloodPressureInfo(bloodList);
		}
		return  JSONObject.toJSONString(response);
	}
	
	
	@RequestMapping("/showAll")
	@ResponseBody
	public String showBlood(){
		Query query = Query.query(Criteria.where("userId").exists(true));
	
		query.with(new Sort(Direction.DESC, "measureTime"));
		
		List<BloodPressureInfo> list =bloodPressureInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	
	
	//上传数据
	@RequestMapping("/upload")
	@ResponseBody
	public String  upload(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		HealthInfoResponse response = new HealthInfoResponse();
		
		int userId = loginInfoService.isOnline(tocken);
		if(userId<0){
			response.setCode("-1");
			response.setMessage("record falure");
		} else {
		long date = jsonObject.getLongValue("measureTime");
		int highBP = jsonObject.getIntValue("highBP");
		int lowBP = jsonObject.getIntValue("lowBP");
		int heartRate = jsonObject.getIntValue("heartRate");
	
		BloodPressureInfo blood = new BloodPressureInfo();
		blood.setUserId(userId);
		blood.setMeasureTime(date);
		blood.setHighBP(highBP);
		blood.setHeartRate(heartRate);
		blood.setLowBP(lowBP);

		//保存数据
		bloodPressureInfoService.save(blood);
		response.setCode("0");
		response.setMessage("record success");
	
		}
		return JSON.toJSONString(response);
		
	}
}
