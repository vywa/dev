package com.hengyun.controller.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.domain.notice.MedicalNoticeResponse;
import com.hengyun.service.notice.MedicalNoticeService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午6:10:10
* 医疗通知控制器
*/
@Controller
@RequestMapping("mnotice")
public class MedicalNoticeController {

	private static final Logger log = LoggerFactory.getLogger(MedicalNoticeController.class);
	@Resource
	private MedicalNoticeService medicalNoticeService;
	
	/*
	 * 
	 * 查询医生所有病人通知
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request,@RequestParam String data){
		
		int userId = (int)request.getAttribute("userId");
		List<MedicalNotice> notices = medicalNoticeService.queryNotice(userId);
		MedicalNoticeResponse response = new MedicalNoticeResponse();
		response.setCode("206");
		response.setMessage("查询医疗通知成功");
		response.setMedicalNoticeList(notices);
		return JSON.toJSONString(response);

	}
	
	/*
	 * 
	 * 医生处理病人通知
	 * 
	 * */
	@RequestMapping(value="/handle",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handle(HttpServletRequest request,@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		int noticeId = jsonObject.getIntValue("noticeId");
		medicalNoticeService.handleNotice(noticeId);
		MedicalNoticeResponse response = new MedicalNoticeResponse();
		
		response.setCode("206");
		response.setMessage("医生处理通知成功");
		
		return JSON.toJSONString(response);
		
	}
}
