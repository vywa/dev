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
import com.hengyun.domain.information.NickIcon;
import com.hengyun.domain.information.NickIconResponse;
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
			
			List<NickIcon> infos = new ArrayList<NickIcon>();
			String birthday = null;
			int age = 0;
			Date date2 = null; 
			for(Integer temp :userList){
				Information information = informationService.query(temp);
				UserAccount userAccount = userAccountService.queryById(temp);
				try {
				 birthday = information.getBirthday();
				String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
	
					date2 = simpleDateFormat.parse(digital);
					age = new Date().getYear()-date2.getYear();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					age = 0;
				}  catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 NickIcon nickIcon = new NickIcon();
				 nickIcon.setIconUrl(information.getIconUrl());
				 nickIcon.setBirthday(information.getBirthday());
				 nickIcon.setEmail(userAccount.getEmail());
				 nickIcon.setHome(information.getHometown());
				 nickIcon.setMobilephone(userAccount.getMobilephone());
				 nickIcon.setQq(userAccount.getQQ());
				 nickIcon.setNickName(information.getTrueName());
				 nickIcon.setTrueName(information.getTrueName());
				 nickIcon.setDisease(information.getDisease());
				 nickIcon.setUserId(userAccount.getId());
				 nickIcon.setWeiBo(userAccount.getWeiBo());
				 nickIcon.setWeiChat(userAccount.getWeiChat());
				 nickIcon.setWorkNum(userAccount.getWorkNum());
				 nickIcon.setAge(age);
				 nickIcon.setSex(information.getSex());
				infos.add(nickIcon);
				
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
			
			List<NickIcon> infos = new ArrayList<NickIcon>();
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
					age=0;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				 NickIcon nickIcon = new NickIcon();
				 nickIcon.setIconUrl(information.getIconUrl());
				 nickIcon.setBirthday(information.getBirthday());
				 nickIcon.setEmail(userAccount.getEmail());
				 nickIcon.setHome(information.getHometown());
				 nickIcon.setMobilephone(userAccount.getMobilephone());
				 nickIcon.setQq(userAccount.getQQ());
				 nickIcon.setNickName(information.getTrueName());
				 nickIcon.setTrueName(information.getTrueName());
				 nickIcon.setDisease(information.getDisease());
				 nickIcon.setUserId(userAccount.getId());
				 nickIcon.setWeiBo(userAccount.getWeiBo());
				 nickIcon.setWeiChat(userAccount.getWeiChat());
				 nickIcon.setWorkNum(userAccount.getWorkNum());
				 nickIcon.setAge(age);
				 nickIcon.setSex(information.getSex());
				infos.add(nickIcon);
			
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
	@RequestMapping(value="/searchPatient2",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String searchPatient2( HttpServletRequest request,@RequestParam String data) {

			RosterResponse response = new RosterResponse();
			int userId = (int)request.getAttribute("userId");
			JSONObject jsonObject = JSON.parseObject(data);
			String searchName = jsonObject.getString("key");
			List<Integer> idList = rosterService.searchFriendList(String.valueOf(userId), searchName);
			
			List<NickIcon> infos=new ArrayList<NickIcon>();
			String birthday = null;
			int age = 0;
			for(int i=0;i<idList.size();i++){
				Information information = informationService.query(idList.get(i));
				UserAccount account = userAccountService.getUserAccountById(idList.get(i));
				try {
					birthday = information.getBirthday();
					String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
					Date date2 = null; 
					date2 = simpleDateFormat.parse(digital);
					 age= new Date().getYear()-date2.getYear();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					age=0;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 NickIcon nickIcon = new NickIcon();
				 nickIcon.setIconUrl(information.getIconUrl());
				 nickIcon.setBirthday(information.getBirthday());
				 nickIcon.setEmail(account.getEmail());
				 nickIcon.setHome(information.getHometown());
				 nickIcon.setMobilephone(account.getMobilephone());
				 nickIcon.setQq(account.getQQ());
				 nickIcon.setDisease(information.getDisease());
				 nickIcon.setNickName(information.getTrueName());
				 nickIcon.setTrueName(information.getTrueName());
				 nickIcon.setUserId(account.getId());
				 nickIcon.setWeiBo(account.getWeiBo());
				 nickIcon.setWeiChat(account.getWeiChat());
				 nickIcon.setWorkNum(account.getWorkNum());
				 nickIcon.setAge(age);
				 nickIcon.setSex(information.getSex());
				infos.add(nickIcon);
			
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
			//int userId = (int)request.getAttribute("userId");
			JSONObject jsonObject = JSON.parseObject(data);
			String searchName = jsonObject.getString("key");
			List<Integer> idList = rosterService.searchPatient(searchName);

			List<NickIcon> infos=new ArrayList<NickIcon>();
			String birthday = null;
			int age = 0;
			for(int i=0;i<idList.size();i++){
				Information information = informationService.query(idList.get(i));
				UserAccount account = userAccountService.getUserAccountById(idList.get(i));
				try {
					birthday = information.getBirthday();
					String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
					Date date2 = null; 
					date2 = simpleDateFormat.parse(digital);
					 age= new Date().getYear()-date2.getYear();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					age=0;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 NickIcon nickIcon = new NickIcon();
				 nickIcon.setIconUrl(information.getIconUrl());
				 nickIcon.setBirthday(information.getBirthday());
				 nickIcon.setEmail(account.getEmail());
				 nickIcon.setHome(information.getHometown());
				 nickIcon.setMobilephone(account.getMobilephone());
				 nickIcon.setQq(account.getQQ());
				 nickIcon.setDisease(information.getDisease());
				 nickIcon.setNickName(information.getTrueName());
				 nickIcon.setTrueName(information.getTrueName());
				 nickIcon.setUserId(account.getId());
				 nickIcon.setWeiBo(account.getWeiBo());
				 nickIcon.setWeiChat(account.getWeiChat());
				 nickIcon.setWorkNum(account.getWorkNum());
				 nickIcon.setAge(age);
				 nickIcon.setSex(information.getSex());
				infos.add(nickIcon);
			
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

					List<NickIcon> infos = new ArrayList<NickIcon>();
					for(int i=0;i<array.size();i++){
						UserAccount account = userAccountService.getUserAccountById(Integer.valueOf(array.getIntValue(i)));
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
							age=0;
						}catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
						 NickIcon nickIcon = new NickIcon();
						 nickIcon.setIconUrl(information.getIconUrl());
						 nickIcon.setBirthday(information.getBirthday());
						 nickIcon.setEmail(account.getEmail());
						 nickIcon.setHome(information.getHometown());
						 nickIcon.setMobilephone(account.getMobilephone());
						 nickIcon.setQq(account.getQQ());
						 nickIcon.setNickName(information.getTrueName());
						 nickIcon.setTrueName(information.getTrueName());
						 nickIcon.setDisease(information.getDisease());
						 nickIcon.setUserId(account.getId());
						 nickIcon.setWeiBo(account.getWeiBo());
						 nickIcon.setWeiChat(account.getWeiChat());
						 nickIcon.setWorkNum(account.getWorkNum());
						 nickIcon.setAge(age);
						 nickIcon.setSex(information.getSex());
						infos.add(nickIcon);
					}
					response.setCode("206");
					response.setMessage("查询成功");
					response.setInfos(infos);
				
				return JSON.toJSONString(response);
			}
}
