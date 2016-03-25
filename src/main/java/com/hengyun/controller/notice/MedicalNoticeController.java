package com.hengyun.controller.notice;

import java.util.ArrayList;
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
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.domain.notice.MedicalNotice;
import com.hengyun.domain.notice.MedicalNoticeDetail;
import com.hengyun.domain.notice.MedicalNoticeResponse;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.UserAccountService;
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
	
	@Resource
	private InformationService informationService;
	
	@Resource
	private UserAccountService userAccountService;
	
	@Resource
	private RosterService rosterService;
	/*
	 * 
	 * 查询医生所有病人通知
	 * 
	 * */
	@RequestMapping(value="/queryNotice",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryNotice(HttpServletRequest request,@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		int freshenType = jsonObject.getIntValue("freshenType");
		int noticeId = jsonObject.getIntValue("noticeId");
		int userId = (int)request.getAttribute("userId");
		List<MedicalNotice> notices = medicalNoticeService.queryNotice(userId, freshenType, noticeId);
		Information info =null;
		UserAccount account=null;
		List<MedicalNoticeDetail> mlist = new ArrayList<MedicalNoticeDetail>();
		
		for(MedicalNotice temp: notices){
			MedicalNoticeDetail medical =new MedicalNoticeDetail();
			int patientId = temp.getNoticeToId();
			info=informationService.query(patientId);
			account= userAccountService.queryById(patientId);
			medical.setUserId(account.getId());
			medical.setAddress(info.getAddress());
			medical.setAge(info.getAge());
			medical.setBirthday(info.getBirthday());
			medical.setContent(temp.getContent());
			medical.setHeight(info.getHeight());
			medical.setDangerLevel(temp.getDangerLevel());
			medical.setMobilephone(account.getMobilephone());
			medical.setNoticeFromId(temp.getNoticeFromId());
			medical.setNoticeId(temp.getNoticeId());
			medical.setNoticeToId(temp.getNoticeToId());
			medical.setNoticeType(temp.getNoticeType());
			medical.setSex(info.getSex());
			medical.setDisease(info.getDisease());
			medical.setTrueName(info.getTrueName());
			medical.setWeight(info.getWeight());
			medical.setAddress(info.getAddress());
			medical.setSendTime(temp.getSendTime());
			medical.setQQ(info.getQQ());
			medical.setEmail(info.getEmail());
			medical.setIconUrl(info.getIconUrl());
			mlist.add(medical);
		}
		MedicalNoticeResponse response = new MedicalNoticeResponse();
		response.setCode("206");
		response.setMessage("查询医疗通知成功");
		response.setMedicalNoticeDetailList(mlist);
		return JSON.toJSONString(response);

	}
	
	/*
	 * 
	 * 查询医生某个病人通知
	 * 
	 * */
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String query(HttpServletRequest request,@RequestParam String data){
		JSONObject jsonObject =JSON.parseObject(data);
		String username = jsonObject.getString("key");
		int userId =(int)request.getAttribute("userId");
		List<Integer> rosterList =rosterService.searchFriendList(String.valueOf(userId), username);
		
		System.out.println(rosterList);
	
		List<MedicalNotice> notices = medicalNoticeService.query(userId, rosterList);
		Information info =null;
		UserAccount account=null;
		List<MedicalNoticeDetail> mlist = new ArrayList<MedicalNoticeDetail>();
		
		for(MedicalNotice temp: notices){
			MedicalNoticeDetail medical =new MedicalNoticeDetail();
			int patientId = temp.getNoticeToId();
			info=informationService.query(patientId);
			account= userAccountService.queryById(patientId);
			medical.setUserId(account.getId());
			medical.setAddress(info.getAddress());
			medical.setAge(info.getAge());
			medical.setBirthday(info.getBirthday());
			medical.setContent(temp.getContent());
			medical.setHeight(info.getHeight());
			medical.setDangerLevel(temp.getDangerLevel());
			medical.setMobilephone(account.getMobilephone());
			medical.setNoticeFromId(temp.getNoticeFromId());
			medical.setNoticeId(temp.getNoticeId());
			medical.setNoticeToId(temp.getNoticeToId());
			medical.setNoticeType(temp.getNoticeType());
			medical.setSex(info.getSex());
			medical.setDisease(info.getDisease());
			medical.setTrueName(info.getTrueName());
			medical.setWeight(info.getWeight());
			medical.setAddress(info.getAddress());
			medical.setSendTime(temp.getSendTime());
			medical.setQQ(info.getQQ());
			medical.setEmail(info.getEmail());
			medical.setIconUrl(info.getIconUrl());
			mlist.add(medical);
		}
		MedicalNoticeResponse response = new MedicalNoticeResponse();
		response.setCode("206");
		response.setMessage("查询医疗通知成功");
		response.setMedicalNoticeDetailList(mlist);
		return JSON.toJSONString(response);

	}
	
	/*
	 * 
	 * 查询医生某种类型病人通知
	 * 
	 * */
	@RequestMapping(value="/doctorQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorQuery(HttpServletRequest request,@RequestParam String data){
		
		JSONObject jsonObject =JSON.parseObject(data);
		int freshenType = jsonObject.getIntValue("freshenType");
		int noticeId = jsonObject.getIntValue("noticeId");
		int type = jsonObject.getIntValue("type");
		int userId = (int)request.getAttribute("userId");
	
		
		List<MedicalNotice> notices = medicalNoticeService.doctorQuery(userId, freshenType, noticeId, type);
		Information info =null;
		UserAccount account=null;
		List<MedicalNoticeDetail> mlist = new ArrayList<MedicalNoticeDetail>();
		
		for(MedicalNotice temp: notices){
			MedicalNoticeDetail medical =new MedicalNoticeDetail();
			int patientId = temp.getNoticeToId();
			info=informationService.query(patientId);
			account= userAccountService.queryById(patientId);
			medical.setUserId(account.getId());
			medical.setAddress(info.getAddress());
			medical.setAge(info.getAge());
			medical.setBirthday(info.getBirthday());
			medical.setContent(temp.getContent());
			medical.setHeight(info.getHeight());
			medical.setDangerLevel(temp.getDangerLevel());
			medical.setMobilephone(account.getMobilephone());
			medical.setNoticeFromId(temp.getNoticeFromId());
			medical.setNoticeId(temp.getNoticeId());
			medical.setNoticeToId(temp.getNoticeToId());
			medical.setDisease(info.getDisease());
			medical.setNoticeType(temp.getNoticeType());
			medical.setSex(info.getSex());
			medical.setTrueName(info.getTrueName());
			medical.setWeight(info.getWeight());
			medical.setAddress(info.getAddress());
			medical.setSendTime(temp.getSendTime());
			medical.setQQ(info.getQQ());
			medical.setEmail(info.getEmail());
			medical.setIconUrl(info.getIconUrl());
			mlist.add(medical);
		}
		MedicalNoticeResponse response = new MedicalNoticeResponse();
		response.setCode("206");
		response.setMessage("查询医疗通知成功");
		response.setMedicalNoticeDetailList(mlist);
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
