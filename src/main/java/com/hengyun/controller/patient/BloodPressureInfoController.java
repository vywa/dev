package com.hengyun.controller.patient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.hengyun.domain.patient.HealthTarget;
import com.hengyun.domain.patient.PressureResponse;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.patient.BloodPressureInfoService;
import com.hengyun.service.patient.HealthTargetService;

/*
 * 
 *  	血压操作
 *  
 * */
@Controller
@RequestMapping("bloodPressure")
public class BloodPressureInfoController {

	private static final Logger log = LoggerFactory.getLogger(BloodPressureInfoController.class);
	
	@Resource
	private BloodPressureInfoService  bloodPressureInfoService;
	
	@Resource
	private LoginInfoService loginInfoService;
	
	@Resource
	private HealthTargetService healthTargetService;
	/*
	 * 
	 * 	查询某个指定时间段的测量数据
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBlood(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		PressureResponse response = new PressureResponse();

		int userId = (int)request.getAttribute("userId");
		
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId);
			
		
		response.setCode("211");//112
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
	}
	
	/*
	 * 
	 *  获取最近一段时间数据记录(单位是天，周，月)
	 * */
	@RequestMapping(value="/latestDay",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String lates(HttpServletRequest request){
	
		PressureResponse response = new PressureResponse();
		int userId = (int)request.getAttribute("userId");
		BloodPressureInfo bpi =  bloodPressureInfoService.getlatestRecord(userId);
		
		List<BloodPressureInfo> bloodList =new ArrayList<BloodPressureInfo>();
		bloodList.add(bpi);
		response.setCode("211");
		
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
	}
	
	/*
	 * 
	 * 	医生查询某个用户的血压记录
	 * 
	 * */
	@RequestMapping(value="/doctorQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorShow(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		PressureResponse response = new PressureResponse();
		int userId2 = jsonObject.getIntValue("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId2);
		response.setCode("211");
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
		
	}
	
	/*
	 * 
	 * 	病人亲属查询某个用户的血压记录
	 * 
	 * */
	@RequestMapping(value="/friendQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String friendQuery(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		PressureResponse response = new PressureResponse();
		int userId2 = jsonObject.getIntValue("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId2);
		response.setCode("211");
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
		
	}
	
	/*
	 * 
	 * 	查询所有用户的血压记录 （管理员）
	 * 
	 * */
	@RequestMapping(value="/showAll",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBlood(){
		Query query = Query.query(Criteria.where("userId").exists(true));
	
		query.with(new Sort(Direction.DESC, "measureTime"));
		
		List<BloodPressureInfo> list =bloodPressureInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	
	
	/*
	 * 
	 *  	上传用户的血压数据
	 *  
	 * */
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  upload(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSON.parseObject(data);
		HealthInfoResponse response = new HealthInfoResponse();
		BloodPressureInfo blood = JSON.toJavaObject(jsonObject, BloodPressureInfo.class);
		int userId = (int)request.getAttribute("userId");
		blood.setUserId(userId);
		/*
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
	*/
		//保存数据
		bloodPressureInfoService.addInfo(blood);
		
		response.setCode("0");//-1
		response.setMessage("血压上传成功");
	
	
		return JSON.toJSONString(response);
		
	}
	
	
}
