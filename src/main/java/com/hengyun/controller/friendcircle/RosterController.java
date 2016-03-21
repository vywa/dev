package com.hengyun.controller.friendcircle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.friendcircle.RosterResponse;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午1:49:57
* 好友类控制器
*/
@Controller
@RequestMapping("roster")
public class RosterController {

	@Resource
	private RosterService rosterService;
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private InformationService informationService;

	@Resource
	private UserAccountService userAccountService;
	
	// 获取好友列表
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String docterRequest( HttpServletRequest request) {

			RosterResponse response = new RosterResponse();
			int userId = (int)request.getAttribute("userId");
			
			
			// 查找是否已经在好友列表中
			List<Integer> userList = rosterService.getFriendList(String.valueOf(userId));
			
			List<Information> infos = new ArrayList<Information>();
			String birthday = null;
			int age = 0;
			Date date2 = null; 
			for(Integer temp :userList){
				Information information = informationService.query(temp);
				try {
				 birthday = information.getBirthday();
				String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
				
				
					date2 = simpleDateFormat.parse(digital);
					age = new Date().getYear()-date2.getYear();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					age = 40;
				}  catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				information.setAge(age);
				infos.add(information);
			}
			response.setCode("206");
			response.setMessage("查询成功");
			response.setInfos(infos);
		
		return JSON.toJSONString(response);
	}
	
	/* 
	 * 	搜索用户信息列表
	 * */
	@RequestMapping(value="/searchList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String searchList( HttpServletRequest request,@RequestParam String data) {

			RosterResponse response = new RosterResponse();
			int userId = (int)request.getAttribute("userId");
			JSONObject jsonObject = JSON.parseObject(data);
			String searchName = jsonObject.getString("key");
			
			// 查找是否已经在好友列表中
			List<Integer> userList = rosterService.getFriendList(String.valueOf(userId));
			
			List<Information> infos = new ArrayList<Information>();
			String trueName  = null;
			for(Integer temp :userList){
				Information information = informationService.query(temp);
				UserAccount userAccount = userAccountService.queryById(temp);
				
				String regex="([\u4e00-\u9fa5]+)";
				Matcher matcher = Pattern.compile(regex).matcher(searchName);
				
				Pattern pattern = Pattern.compile("[0-9]*");
				boolean mobile= pattern.matcher(searchName).matches(); 
				if(matcher.find()){
					trueName = information.getTrueName();
					 if(trueName==null){
						 continue;
					 }
				}else if(mobile){
					
					 trueName = userAccount.getMobilephone();	
					 if(trueName==null){
						 continue;
					 }
				}  else {
					trueName= information.getTrueName();
					if(trueName==null){
						continue;
					}
				
				}
				if(trueName.startsWith(searchName)){
				String birthday;
				int age=45;
				try {
					birthday = information.getBirthday();
					String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
					Date date2 = null; 
					date2 = simpleDateFormat.parse(digital);
					 age= new Date().getYear()-date2.getYear();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					age=30;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				information.setAge(age);
				infos.add(information);
				}
			}
			response.setCode("206");
			response.setMessage("查询成功");
			response.setInfos(infos);
		
		return JSON.toJSONString(response);
	}
	
	/* 
	 * 	搜索用户信息列表
	 * */
	@RequestMapping(value="/searchPatient",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String searchPatient( HttpServletRequest request,@RequestParam String data) {

			RosterResponse response = new RosterResponse();
			int userId = (int)request.getAttribute("userId");
			JSONObject jsonObject = JSON.parseObject(data);
			String searchName = jsonObject.getString("key");
	
			List<Information> infos=new ArrayList<Information>();
			String trueName  = null;
		
				String regex="([\u4e00-\u9fa5]+)";
				Matcher matcher = Pattern.compile(regex).matcher(searchName);
				
				Pattern pattern = Pattern.compile("[0-9]*");
				String birthday;
				int age=45;
				
				boolean mobile= pattern.matcher(searchName).matches(); 
				if(mobile){
					Query query = new Query();
					Pattern pattern1 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
					query =query.addCriteria(Criteria.where("mobilephone").regex(pattern1));
					List<UserAccount> ulist = userAccountService.queryList(query);
					for(int i=0;i<ulist.size();i++){
						Information information = informationService.query(ulist.get(i).getId());
						try {
							birthday = information.getBirthday();
							String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
							Date date2 = null; 
							date2 = simpleDateFormat.parse(digital);
							 age= new Date().getYear()-date2.getYear();
						} catch (NullPointerException e1) {
							// TODO Auto-generated catch block
							age=30;
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						information.setAge(age);
						infos.add(information);
					}
				}
				else if(matcher.find()){
					Query query = new Query();
					Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
					query =query.addCriteria(Criteria.where("trueName").regex(pattern2));
					 List<Information> tempList = informationService.queryList(query);
					 for(Information temp : tempList){
						 try {
								birthday = temp.getBirthday();
								String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
								Date date2 = null; 
								date2 = simpleDateFormat.parse(digital);
								 age= new Date().getYear()-date2.getYear();
							} catch (NullPointerException e1) {
								// TODO Auto-generated catch block
								age=30;
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						 temp.setAge(age);
						 infos.add(temp);
					 } 
				} else {
					Query query = new Query();
					Pattern pattern2 = Pattern.compile("^" + searchName + ".*$", Pattern.CASE_INSENSITIVE);
					query =query.addCriteria(Criteria.where("trueName").regex(pattern2));
					 List<Information> tempList = informationService.queryList(query);
					 for(Information temp : tempList){
						 try {
								birthday = temp.getBirthday();
								String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
								Date date2 = null; 
								date2 = simpleDateFormat.parse(digital);
								 age= new Date().getYear()-date2.getYear();
							} catch (NullPointerException e1) {
								// TODO Auto-generated catch block
								age=30;
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						 temp.setAge(age);
						 infos.add(temp);
					 }
				}

			response.setCode("206");
			response.setMessage("查询成功");
			response.setInfos(infos);
		
		return JSON.toJSONString(response);
	}
		
		/* 
		 * 获取指定的用户信息列表
		 * */
			@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
			@ResponseBody
			public String docterRequest( HttpServletRequest request,@RequestParam String data) {

					RosterResponse response = new RosterResponse();			
					JSONObject jsonObject = JSON.parseObject(data);
					JSONArray array = JSONArray.parseArray(jsonObject.getString("list"));

					List<Information> infos = new ArrayList<Information>();
					for(int i=0;i<array.size();i++){
		
						Information information = informationService.query(Integer.valueOf(array.getIntValue(i)));
						String birthday;
						SimpleDateFormat simpleDateFormat=null;
						String digital=null;
						Date date2 = null; 
						int age=0;
						try {
							birthday = information.getBirthday();
							 digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
							simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
							date2 = simpleDateFormat.parse(digital);
							age = new Date().getYear()-date2.getYear();
						} catch (NullPointerException e1) {
							// TODO Auto-generated catch block
							age=45;
						}catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						information.setAge(age);
						infos.add(information);
					}
					response.setCode("206");
					response.setMessage("查询成功");
					response.setInfos(infos);
				
				return JSON.toJSONString(response);
			}
}
