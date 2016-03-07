package com.hengyun.controller.forum;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.forum.ForumResponseCode;
import com.hengyun.domain.forum.PostListResponseCode;
import com.hengyun.domain.forum.Subject;
import com.hengyun.domain.information.Information;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("subject")  
public class SubjectController {   
    @Resource
    private LoginInfoService loginInfoService;
    @Resource
    private InformationService informationService;
	@Resource
	private SubjectService subjectService;
	
	//发送帖子
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		ForumResponseCode response = new ForumResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		Subject post = JSON.toJavaObject(jsonObject, Subject.class);
	
		String tocken = request.getParameter("tocken");
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			
			subjectService.post(post, tocken);
			response.setResponseCode(0);
			response.setDescription("发帖成功");
		} else {
			response.setResponseCode(-1);
			response.setDescription("发帖失败");
		}

		return JSON.toJSONString(response);
	}
	
	
	//更新帖子
	@RequestMapping("/update")
	@ResponseBody
	public String updateHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Subject post = JSON.toJavaObject(jsonObject, Subject.class);
		Query query = Query.query(Criteria.where("subjectId").is(post.getSubjectId()));
		Update update = Update.update("title",post.getTitle()).set("content", post.getContent());
		subjectService.updateInser(query, update);

		ForumResponseCode response = new ForumResponseCode();
		response.setResponseCode(0);
		response.setDescription("更新成功");
		return JSON.toJSONString(response);
	}
	
	//设置帖子
	@RequestMapping("/set")
	@ResponseBody
	public String setPost(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showPost(HttpServletRequest request){
	
		List<Subject> postList = subjectService.showAll();

		return JSON.toJSONString(postList);
	}
	
	
	//查看某个帖子的回复列表
	@RequestMapping(value="/subjectDetail")
	@ResponseBody
	public String queryPost(@RequestParam String data,HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
	
		List<Subject> postList = subjectService.show(tocken);

		return JSON.toJSONString(postList);
	}
	
	
	
	//条件查询帖子列表
	@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryList(@RequestParam String data,HttpServletRequest request){
		//String tocken = request.getParameter("tocken");
		PostListResponseCode response = new PostListResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
		int subjectId = jsonObject.getIntValue("subjectId");
		int subjectType = jsonObject.getIntValue("subjectType");
		int freshenType = jsonObject.getIntValue("freshenType");
		String keyWord = jsonObject.getString("keyWord");
		
		//加载某人，某类，之前后包含关键字的帖子列表
		List<Subject> postList =subjectService.showList(userId, subjectId, subjectType, freshenType);
		
		response.setSubjectList(postList);
		response.setResponseCode(0);
		response.setDescription("获取列表成功");
		return JSON.toJSONString(response);
	}
	
	
	//某个id对应的帖子
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String idPost(@RequestParam String data,HttpServletRequest request){
	//	String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
		PostListResponseCode response = new PostListResponseCode();
		int subjectId = jsonObject.getIntValue("subjectId");

		subjectService.delete(subjectId);
		response.setResponseCode(0);
		response.setDescription("删帖成功");
		return JSON.toJSONString(response);
	}
	
	
	
	
}