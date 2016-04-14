package com.hengyun.controller.information;

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
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.Collection;
import com.hengyun.domain.information.CollectionResponse;
import com.hengyun.domain.information.DailyNewsCollection;
import com.hengyun.service.information.CollectionService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:48:11
* 收藏控制器
*/
@Controller
@RequestMapping("collection")
public class CollectionController {

	
	private static final Logger log = LoggerFactory.getLogger(CollectionController.class);
	
	@Resource
	private CollectionService collectionService;
	
	
	/*
	 *  收藏帖子
	 * */
	@RequestMapping(value="subject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String subject(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		
		DailyNewsCollection collection = JSON.toJavaObject(jsonObject, DailyNewsCollection.class);
		int userId = (int)request.getAttribute("userId");
		
		int result = collectionService.addCollection(collection, userId, 0);
		if(result<0){
			response.setCode("110");
			response.setMessage("你已经收藏，不能重复");
		} else {
		response.setCode("206");
		response.setMessage("收藏帖子成功");
		}

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  收藏资讯
	 * */
	@RequestMapping(value="dailyNews",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dailyNews(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		DailyNewsCollection collection = JSON.toJavaObject(jsonObject, DailyNewsCollection.class);
		int userId = (int)request.getAttribute("userId");
		int result = collectionService.addCollection(collection, userId,1);
		if(result<0){
			response.setCode("110");
			response.setMessage("你已经收藏，不能重复");
		} else {
		response.setCode("206");
		response.setMessage("收藏帖子成功");
		}

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  收藏及时通信内容
	 * */
	@RequestMapping(value="im",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String im(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		DailyNewsCollection collection = JSON.toJavaObject(jsonObject, DailyNewsCollection.class);
		int userId = (int)request.getAttribute("userId");
		int result = collectionService.addCollection(collection, userId, 2);
		if(result<0){
			response.setCode("110");
			response.setMessage("你已经收藏，不能重复");
		} else {
		response.setCode("206");
		response.setMessage("收藏帖子成功");
		}

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  查看用户收藏列表
	 * */
	@RequestMapping(value="list",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		Collection list = collectionService.show(userId);
		response.setCode("206");
		response.setMessage("查询成功");
		response.setCollection(list);

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  删除帖子列表
	 * */
	@RequestMapping(value="dsubject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dsubject(@RequestParam String data,HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		
		int id = jsonObject.getIntValue("id");
		collectionService.delete(userId, id, 0);
		response.setCode("206");
		response.setMessage("删除帖子成功");

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  删除资讯列表
	 * */
	@RequestMapping(value="ddailyNews",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ddailyNews(@RequestParam String data,HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		collectionService.delete(userId, id, 1);
		response.setCode("206");
		response.setMessage("删除资讯成功");

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  删除及时通信列表
	 * */
	@RequestMapping(value="dim",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dim(@RequestParam String data,HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		collectionService.delete(userId, id, 2);
		response.setCode("206");
		response.setMessage("删除及时通信成功");

		return JSON.toJSONString(response);
		
	}
	
}
