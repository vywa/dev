package com.hengyun.controller.friendcircle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.friendcircle.RosterResponse;
import com.hengyun.domain.information.Information;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

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

	// 获取好友列表
	@RequestMapping(value="/query",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String docterRequest( HttpServletRequest request) {
	//	JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		//int jid = jsonObject.getIntValue("userId");
		RosterResponse response = new RosterResponse();
		int userId = loginInfoService.isOnline(tocken);
		
	
			// 查找是否已经在好友列表中
			List<Integer> userList = rosterService.getFriendList(String.valueOf(userId));
			List<Information> infos = new ArrayList<Information>();
			
			for(Integer temp :userList){
				infos.add(informationService.query(temp));
			}
			response.setCode("206");
			response.setMessage("查询成功");
			response.setInfos(infos);
		
		return JSON.toJSONString(response);
	}
}
