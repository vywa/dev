package com.hengyun.controller.information;

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
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.Collection;
import com.hengyun.domain.information.CollectionResponse;
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
	 *  收藏
	 * */
	@RequestMapping("add")
	@ResponseBody
	public String add(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		Collection collection = JSON.toJavaObject(jsonObject, Collection.class);
		int userId = (int)request.getAttribute("userId");
		collection.setUserId(userId);
		collectionService.addCollection(collection);
		response.setCode("206");
		response.setMessage("收藏成功");

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  查看用户收藏列表
	 * */
	@RequestMapping("list")
	@ResponseBody
	public String list(HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		List<Collection> list = collectionService.show(userId);
		response.setCode("206");
		response.setMessage("查询成功");
		response.setCollectionList(list);

		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  删除收藏列表
	 * */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(@RequestParam String data,HttpServletRequest request){
	
		CollectionResponse response = new CollectionResponse();
		int userId =(int)request.getAttribute("userId");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		collectionService.delete(id);
		response.setCode("206");
		response.setMessage("删除成功");

		return JSON.toJSONString(response);
		
	}
}
