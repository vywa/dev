package com.hengyun.controller.notice;

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
import com.hengyun.controller.BaseController;
import com.hengyun.domain.notice.DailyNews;
import com.hengyun.domain.notice.DailyNewsListResponse;
import com.hengyun.domain.notice.DailyNewsResponse;
import com.hengyun.domain.notice.DailyNewsResponseList;
import com.hengyun.service.notice.DailyNewsService;

/*
 * 
 *  每日推送控制器
 *  
 * */

@Controller
@RequestMapping("dnews")
public class DailyNewsController extends BaseController{
	
	@Resource
	private DailyNewsService dailyNewsService;
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String addNotice(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		DailyNews dailyNews = JSON.toJavaObject(jsonObject, DailyNews.class);
		dailyNewsService.add(dailyNews);
		DailyNewsResponse response = new DailyNewsResponse();
		response.setCode("206");
		response.setMessage("添加咨询成功");

		return JSON.toJSONString(response);
	}
	

	

		/*
		 * 
		 *  病人加载咨讯列表
		 * 
		 * */
		@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryList(HttpServletRequest request){
			int userId =(int)request.getAttribute("userId");
			List<DailyNewsResponseList> dailyList = new ArrayList<DailyNewsResponseList>();
			List<DailyNews> list = dailyNewsService.queryList();
			for(DailyNews dn :list){
				DailyNewsResponseList dnl = new DailyNewsResponseList();
				
				dnl.setContent(dn.getContent());
				dnl.setId(dn.getId());
				dnl.setImageUrl(dn.getImageUrl());
				dnl.setPublishTime(dn.getPublishTime());
				dnl.setTitle(dn.getTitle());
				dnl.setUrl(dn.getUrl());
				
				List<Integer> il = dn.getCollectorId();
				boolean collected = false;
				if(il==null){
				
				}else{
				
				for(Integer temp :il){
					if(temp==userId){
						collected=true;
						break;
					}
				}
				}
				dnl.setCollected(collected);
				dailyList.add(dnl);
	
				}
			DailyNewsListResponse response = new DailyNewsListResponse();
			response.setCode("206");
			response.setMessage("查询成功");
			response.setDaily(dailyList);
			return  JSON.toJSONString(response);
		
		
		}
		
		/*
		 * 
		 *  医生加载咨讯列表
		 * 
		 * */
		@RequestMapping(value="/newsList",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String newsList(HttpServletRequest request){
			int userId =(int)request.getAttribute("userId");
			List<DailyNewsResponseList> dailyList = new ArrayList<DailyNewsResponseList>();
			List<DailyNews> list = dailyNewsService.queryList();
			for(DailyNews dn :list){
				DailyNewsResponseList dnl = new DailyNewsResponseList();
				
				dnl.setContent(dn.getContent());
				dnl.setId(dn.getId());
				dnl.setImageUrl(dn.getImageUrl());
				dnl.setPublishTime(dn.getPublishTime());
				dnl.setTitle(dn.getTitle());
				dnl.setUrl(dn.getUrl());
				List<Integer> il = dn.getCollectorId();
				boolean collected = false;
				if(il==null){
				
				}else{
				
				for(Integer temp :il){
					if(temp==userId){
						collected=true;
						break;
					}
				}
				}
				dnl.setCollected(collected);
				dailyList.add(dnl);
			}
			DailyNewsListResponse response = new DailyNewsListResponse();
			response.setCode("206");
			response.setMessage("查询成功");
			response.setDaily(dailyList);
			return  JSON.toJSONString(response);
		
		
		
		}
}
