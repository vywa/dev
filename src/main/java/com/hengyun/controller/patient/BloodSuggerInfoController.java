package com.hengyun.controller.patient;

import java.util.List;

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
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.patient.BloodSuggerInfo;
import com.hengyun.domain.patient.HealthInfoResponse;
import com.hengyun.domain.patient.SuggerResponse;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.patient.BloodSuggerInfoService;

/*
 * 
 *  血糖操作
 * */
@Controller
@RequestMapping("bloodSugger")
public class BloodSuggerInfoController {

	 private static final Logger log = LoggerFactory.getLogger(BloodSuggerInfoController.class);
	@Resource
	private BloodSuggerInfoService  bloodSuggerInfoService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	@RequestMapping("/show")
	@ResponseBody
	public String showBloodSugger(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		String user = jsonObject.getString("userId");
		SuggerResponse sugger = new SuggerResponse();
		int userId = loginInfoService.isOnline(tocken);
		if(userId<0){
			sugger.setCode("112");
			sugger.setBloodSuggerInfo(null);
		} else {
		
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		System.out.println(userId);
		List<BloodSuggerInfo> bloodList = bloodSuggerInfoService.getInfoByTime(startTime, endTime, userId);
	
		sugger.setCode("211");
		sugger.setBloodSuggerInfo(bloodList);
		}
		return  JSONObject.toJSONString(sugger);
	}
	
	@RequestMapping("/showAll")
	@ResponseBody
	public String showBloodSuggerAll(HttpServletRequest request){
		Query query = Query.query(Criteria.where("userId").exists(true));
		String tocken = request.getParameter("tocken");
		
		int userId = loginInfoService.isOnline(tocken);
		
		List<BloodSuggerInfo> list =bloodSuggerInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	@RequestMapping("/latestDay")
	@ResponseBody
	public String lates(HttpServletRequest request){
	
		SuggerResponse response = new SuggerResponse();
		String tocken = request.getParameter("tocken");
		//String user = jsonObject.getString("userId");
		List<BloodSuggerInfo> bloodList = null;
		int userId = loginInfoService.isOnline(tocken);
		
		if(userId<0){
			response.setCode("112");
			response.setBloodSuggerInfo(null);
		} else {
		
			try{
				bloodList = bloodSuggerInfoService.getlatestTime(userId);
				if(bloodList!=null){
					response.setCode("211");
					response.setBloodSuggerInfo(bloodList);
				}
			} catch(Exception ex){
				log.info("病人 "+userId+"最近的血糖信息为空");
				response.setCode("211");
				response.setBloodSuggerInfo(null);
			}
		
		}
		return  JSONObject.toJSONString(response);
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
			response.setMessage("record failure");
		} else {
		
		long date = jsonObject.getLongValue("measureTime");
	   
		double bsValue = jsonObject.getDoubleValue("bsValue");
		int measureType = jsonObject.getIntValue("measureType");

		BloodSuggerInfo sugger = new BloodSuggerInfo();
		sugger.setUserId(userId);
		sugger.setBsValue(bsValue);
		sugger.setMeasureTime(date);	
		sugger.setMeasureType(measureType);

		//保存数据
		bloodSuggerInfoService.save(sugger);
		response.setCode("0");
		response.setMessage("record success");
		
		}
		return  JSON.toJSONString(response);
		
	}
}
