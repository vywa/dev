package com.hengyun.controller.friendcircle;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.friendcircle.Friend;
import com.hengyun.domain.information.Information;
import com.hengyun.service.friendcircle.FriendCircleService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  朋友圈管理
 * */
@Controller
@RequestMapping("circle")
public class FriendCircleController {

	@Resource
	private FriendCircleService friendCircleService;
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private InformationService informationService;

	// 病人请求添加医生
	@RequestMapping("/docterRequest")
	@ResponseBody
	public String docterRequest(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");

		int docterId = Integer.valueOf(request.getParameter("id"));
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);
		// 设置对方数据库中自己为病人

		int userId = loginInfoService.isOnline(tocken);

		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			// 查找是否已经在好友列表中
			if (friendCircleService.isDocter(docterId, userId) < 0) {
				// 向好友对象未处理表中添加数据
				Information info = informationService.query(userId);
				friend.setFriendId(userId);
				friend.setFriendName(info.getTrueName());
				friend.setRelation("patient");
				friendCircleService.addUnhandled(friend, docterId);
				response.setCode("206");
				response.setMessage("request docter");
			} else {
				response.setCode("102");
				response.setMessage("already friend");
			}
		} else {
			response.setCode("104");
			response.setMessage("unlogin");
		}
		return JSON.toJSONString(response);
	}

	// 医生请求添加病人
	@RequestMapping("/patientRequest")
	@ResponseBody
	public String patientRequest(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		int patientId = Integer.valueOf(request.getParameter("id"));
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);

		int userId = loginInfoService.isOnline(tocken);

		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			// 查找是否已经在好友列表中
			if (friendCircleService.isPatient(patientId, userId) < 0) {
				Information info = informationService.query(userId);
				friend.setFriendId(userId);
				friend.setFriendName(info.getTrueName());
				friend.setRelation("docter");
				friendCircleService.addUnhandled(friend, patientId);
				response.setCode("206");
				response.setMessage("request docter");
			} else {
				response.setCode("102");
				response.setMessage("already friend");
			}
		} else {
			response.setCode("104");
			response.setMessage("unlogin");
		}

		return JSON.toJSONString(response);
	}

	// 添加朋友
	@RequestMapping("/friendRequest")
	@ResponseBody
	public String friendRequest(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		// 获取对方的id
		int otherId = Integer.valueOf(request.getParameter("id"));
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);
		int userId = loginInfoService.isOnline(tocken);
		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			if (friendCircleService.isFriend(friend.getFriendId(), userId) < 0) {
				// 向好友对象未处理表中添加数据
				Information info = informationService.query(userId);
				friend.setFriendId(userId);
				friend.setFriendName(info.getTrueName());
				friend.setRelation("friend");
				friendCircleService.addUnhandled(friend, otherId);
				response.setCode("206");
				response.setMessage("add sucess");
			} else {
				response.setCode("102");
				response.setMessage("already friend");
			}
		} else {
			response.setCode("104");
			response.setMessage("unlogin");
		}

		return JSON.toJSONString(response);
	}

	// 处理添加病人
	@RequestMapping("/addPatient")
	@ResponseBody
	public String addPatient(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);
		friend.setRelation("patient");
		int userId = loginInfoService.isOnline(tocken);

		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			friendCircleService.addFriend(friend, userId);
		}
		response.setCode("206");
		response.setMessage("add sucess");

		return JSON.toJSONString(response);
	}

	// 处理添加医生
	@RequestMapping("/addDocter")
	@ResponseBody
	public String addDocter(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);
		friend.setRelation("docter");
		int userId = loginInfoService.isOnline(tocken);

		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			friendCircleService.addFriend(friend, userId);
		}
		response.setCode("206");
		response.setMessage("add sucess");

		return JSON.toJSONString(response);
	}

	// 处理添加好友
	@RequestMapping("/addFriend")
	@ResponseBody
	public String addFriend(@RequestParam String data, HttpServletRequest request) {
		JSONObject jsonObject = JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		Friend friend = JSON.toJavaObject(jsonObject, Friend.class);
		friend.setRelation("friend");
		int userId = loginInfoService.isOnline(tocken);

		ResponseCode response = new ResponseCode();

		if (userId > 0) {
			friendCircleService.addFriend(friend, userId);
		}
		response.setCode("206");
		response.setMessage("add sucess");

		return JSON.toJSONString(response);
	}

	// 获取病人列表
	@RequestMapping("/getPatient")
	@ResponseBody
	public String getFriend(@RequestParam String data, HttpServletRequest request) {

		String tocken = request.getParameter("tocken");

		int userId = loginInfoService.isOnline(tocken);

		List<Friend> friends = null;
		if (userId > 0) {
			friends = friendCircleService.getPatients(userId);
		}

		return JSON.toJSONString(friends);
	}

	// 获取医生列表
	@RequestMapping("/getDocter")
	@ResponseBody
	public String getDocter(@RequestParam String data, HttpServletRequest request) {

		String tocken = request.getParameter("tocken");

		int userId = loginInfoService.isOnline(tocken);

		List<Friend> friends = null;
		if (userId > 0) {
			friends = friendCircleService.getDocters(userId);
		}

		return JSON.toJSONString(friends);
	}

	// 获取未处理列表
	@RequestMapping("/getUnhandled")
	@ResponseBody
	public String getUnhandled(@RequestParam String data, HttpServletRequest request) {

		String tocken = request.getParameter("tocken");

		int userId = loginInfoService.isOnline(tocken);

		List<Friend> friends = null;
		if (userId > 0) {
			friends = friendCircleService.getUnhandled(userId);
		}

		return JSON.toJSONString(friends);
	}

}
