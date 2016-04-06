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
import com.hengyun.domain.forum.PostListResponseCode;
import com.hengyun.domain.forum.Subject;
import com.hengyun.domain.notice.DailyNews;
import com.hengyun.domain.notice.DailyNewsResponse;
import com.hengyun.service.notice.DailyNewsService;

/*
 * 
 *  每日推送控制器
 *  
 * */

@Controller
@RequestMapping("dnews")
public class DailyNewsController {
	
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
	 *  加载资讯
	 * 
	 * */
	@RequestMapping("/load")
	@ResponseBody
	public String load(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
		DailyNews dn = dailyNewsService.query(id);
		List<DailyNews> daily = new ArrayList<DailyNews>();
		daily.add(dn);
		DailyNewsResponse response = new DailyNewsResponse();
		response.setCode("206");
		response.setMessage("加载成功");
		response.setDaily(daily);
		return JSON.toJSONString(response);
		
	}
	

		/*
		 * 
		 *  加载咨讯列表
		 * 
		 * */
		@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryList(HttpServletRequest request){
			List<DailyNews> list = dailyNewsService.queryList();
			DailyNewsResponse response = new DailyNewsResponse();
			response.setCode("206");
			response.setMessage("查询成功");
			response.setDaily(list);
			return  JSON.toJSONString(response);
		
		
		}
		
	
}
