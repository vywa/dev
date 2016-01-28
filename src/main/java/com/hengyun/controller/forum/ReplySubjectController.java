package com.hengyun.controller.forum;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.forum.ForumResponseCode;
import com.hengyun.domain.forum.ReplyListResponseCode;
import com.hengyun.domain.forum.ReplySubject;
import com.hengyun.domain.information.Information;
import com.hengyun.service.forum.ReplySubjectService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("replysubject")  
public class ReplySubjectController {   
    @Resource
    private LoginInfoService loginInfoService;
    
	@Resource
	private ReplySubjectService replySubjectService;
	@Resource
	private InformationService informationService;
	//发送回复
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		ForumResponseCode response = new ForumResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		ReplySubject post = JSON.toJavaObject(jsonObject, ReplySubject.class);
	
		String tocken = request.getParameter("tocken");
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Information info = new Information();
			Query query = Query.query(Criteria.where("userId").is(userId));
			info = informationService.queryOne(query);
			post.setReplyAuthor(info.getTrueName());
			post.setReplyLocInfo(info.getIconUrl());
		
			replySubjectService.post(post, userId);
			response.setResponseCode(0);
			response.setDescription("发送成功");
		} else {
			response.setResponseCode(-1);
			response.setDescription("发送失败");
		}

		return JSON.toJSONString(response);
	}
	
	//条件查询帖子列表
		@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryList(@RequestParam String data,HttpServletRequest request){
			//String tocken = request.getParameter("tocken");
			ReplyListResponseCode response = new ReplyListResponseCode();
			JSONObject jsonObject =JSON.parseObject(data);
			int userId = jsonObject.getIntValue("userId");
			int subjectId = jsonObject.getIntValue("subjectId");
			int replyId = jsonObject.getIntValue("replyId");
	
			
			//加载某人，某类，之前后包含关键字的帖子列表
			List<ReplySubject> postList =replySubjectService.showList(userId, subjectId, replyId);
			response.setReplyList(postList);
			response.setResponseCode(0);
			response.setDescription("获取列表成功");
			return JSON.toJSONString(postList);
		}
	
}