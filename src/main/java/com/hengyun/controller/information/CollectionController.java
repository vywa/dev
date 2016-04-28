package com.hengyun.controller.information;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.forum.PostListResponseCode;
import com.hengyun.domain.forum.Subject;
import com.hengyun.domain.information.Collection;
import com.hengyun.domain.information.CollectionResponse;
import com.hengyun.domain.information.DailyNewsCollection;
import com.hengyun.domain.notice.DailyNews;
import com.hengyun.domain.notice.DailyNewsResponse;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.information.CollectionService;
import com.hengyun.service.notice.DailyNewsService;
import com.hengyun.util.network.NetworkUtil;

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
	@Resource
	private SubjectService subjectService;
	@Resource
	private DailyNewsService dailyNewsService;

	/*
	 *  收藏帖子
	 * */
	@RequestMapping(value="subject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String subject(@RequestParam String data,HttpServletRequest request){
	
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		int subjectId = jsonObject.getIntValue("id");
		String ip = NetworkUtil.getPhysicalHostIP();
    	String url = "http://"+ip+"/healthcloudserver/subject/details?id="+subjectId;   	
		DailyNewsCollection collection = new DailyNewsCollection();
		collection.setId(subjectId);
		collection.setUrl(url);
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
		int newsId = jsonObject.getIntValue("id");
		DailyNews dailyNews = dailyNewsService.queryById(newsId);
		String url = dailyNews.getUrl();
		
		int userId = (int)request.getAttribute("userId");
		DailyNewsCollection collection = new DailyNewsCollection();
		collection.setId(newsId);
    	
    	collection.setUrl(url);
    	//用户收藏
		int result = collectionService.addCollection(collection, userId,1);
		Query query = Query.query(Criteria.where("id").is(newsId));
		List<Integer> userList = dailyNews.getCollectorId();
		if(userList==null){
			userList = new ArrayList<Integer>();
		}
		userList.add(userId);
		Update update = Update.update("collectorId", userList);
		//更新收藏者列表
		dailyNewsService.updateFirst(query, update);
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
	 *  查看用户资讯收藏列表
	 * */
	@RequestMapping(value="viewNews",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String viewNews(HttpServletRequest request){
		DailyNewsResponse response = new DailyNewsResponse();
		int userId =(int)request.getAttribute("userId");
		Collection list = collectionService.show(userId);
		if(list==null){
			response.setCode("206");
			response.setMessage("查询成功");
			response.setDaily(null);
			return JSON.toJSONString(response);
		}
		List<DailyNewsCollection> dailyList = list.getDailyNewsList();
	
		if(dailyList==null){
			response.setDaily(null);
		} else {
	
		List<DailyNews> dlist = new ArrayList<DailyNews>();
		
		for(DailyNewsCollection temp:dailyList){
			DailyNews daily = dailyNewsService.queryById(temp.getId());
			dlist.add(daily);
		}
		response.setDaily(dlist);
		}
		response.setCode("206");
		response.setMessage("查询成功");
	

		return JSON.toJSONString(response);
		
	}

	
	/*
	 *  查看用户帖子收藏列表
	 * */
	@RequestMapping(value="viewSubject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String viewSubject(HttpServletRequest request){
		PostListResponseCode response = new PostListResponseCode();
		int userId =(int)request.getAttribute("userId");
		Collection list = collectionService.show(userId);
		if(list==null){
			response.setCode("206");
			response.setMessage("查询成功");
			response.setSubjectList(null);
			return JSON.toJSONString(response);
		}
		List<DailyNewsCollection> dailyList = list.getSubjectList();
	
		if(dailyList==null){
			response.setSubjectList(null);
		} else{
		List<Subject> dlist = new ArrayList<Subject>();
		
		for(DailyNewsCollection temp:dailyList){
			Query query = Query.query(Criteria.where("subjectId").is(temp.getId()));
			Subject daily = subjectService.queryOne(query);
			dlist.add(daily);
			
		}
		response.setSubjectList(dlist);
		}
		response.setCode("206");
		response.setMessage("查询帖子收藏成功");
		
		response.setResponseCode(0);
		response.setDescription("获取列表成功");
		
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
		response.setMessage("取消收藏帖子成功");

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
		response.setMessage("取消收藏资讯成功");

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
