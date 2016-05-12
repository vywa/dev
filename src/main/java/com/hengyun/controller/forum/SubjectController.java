package com.hengyun.controller.forum;

import java.util.ArrayList;
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
import com.hengyun.controller.BaseController;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.forum.ForumResponseCode;
import com.hengyun.domain.forum.PostListResponseCode;
import com.hengyun.domain.forum.Subject;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.impl.forum.util.SubjectToResponse;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.util.json.JSONUtil;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("subject")  
public class SubjectController extends BaseController{   
    @Resource
    private LoginInfoService loginInfoService;
    @Resource
    private InformationService informationService;
	@Resource
	private SubjectService subjectService;
	
	@Resource
	private RosterService rosterService;
	
	/*
	 *  发送帖子
	 * 
	 * */
	@RequestMapping(value="/add",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		ForumResponseCode response = new ForumResponseCode();
		JSONObject jsonObject =JSONUtil.parseObject(data);
		Subject post = JSON.toJavaObject(jsonObject, Subject.class);
		
		int userId =(int) request.getAttribute("userId");
		//发表帖子
		int result = subjectService.post(post, userId);
		
		response.setResponseCode(0);
		response.setDescription("发帖成功");


		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 
	 *  帖子点赞
	 * 
	 * */
	@RequestMapping(value="/like",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String like(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSONUtil.parseObject(data);
		int subjectId = jsonObject.getIntValue("subjectId");
	//	Subject post = JSON.toJavaObject(jsonObject, Subject.class);
		
		int userId =(int) request.getAttribute("userId");
		
		//发表帖子
		int result = subjectService.like(userId, subjectId);
		if(result==-1){
			response.setCode(String.valueOf(-1));
			response.setMessage("你已经点过赞了，不能重复");
		}else {
		
		response.setCode(String.valueOf(0));
		response.setMessage("点赞成功");
		}

		return JSON.toJSONString(response);
	}
	
	
	//更新帖子
	@RequestMapping("/update")
	@ResponseBody
	public String updateHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		Subject post = JSONUtil.toJavaObject(jsonObject, Subject.class);
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
	
	/*
	 *  显示所有帖子
	 * */
	@RequestMapping("/show")
	@ResponseBody
	public String showPost(HttpServletRequest request){
	
		List<Subject> postList = subjectService.showAll();

		return JSON.toJSONString(postList);
	}
	
	/*
	 *  显示所有好友的帖子
	 * */
	@RequestMapping("/friendsSubject")
	@ResponseBody
	public String friendsSubject(@RequestParam String data,HttpServletRequest request){
		PostListResponseCode response = new PostListResponseCode();
		int userId = (int)request.getAttribute("userId");
		JSONObject jsonObject =JSONUtil.parseObject(data);
		int subjectId = jsonObject.getIntValue("subjectId");
		int freshenType = jsonObject.getIntValue("freshenType");
		List<Subject> postList = subjectService.friendsSubject(userId, subjectId, freshenType);
		
		response.setSubjectList(postList);
		response.setResponseCode(0);
		response.setDescription("获取列表成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 *  查看某个好友的所有帖子
	 * */
	
	@RequestMapping(value="/friendSubject")
	@ResponseBody
	public String friendSubject(@RequestParam String data,HttpServletRequest request){
		int userId =(int)request.getAttribute("userId");
		JSONObject jsonObject =JSONUtil.parseObject(data);
		int subjectId = jsonObject.getIntValue("subjectId");
		int freshenType = jsonObject.getIntValue("freshenType");
		
		int authorId = jsonObject.getIntValue("authorId");
		List<Subject> postList=null;
		
		postList = subjectService.friendSubject(userId,authorId, subjectId, freshenType);
	
		return JSON.toJSONString(postList);
	}
	
	
	
	//条件查询帖子列表
	@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryList(@RequestParam String data,HttpServletRequest request){
		
		PostListResponseCode response = new PostListResponseCode();
		JSONObject jsonObject =JSONUtil.parseObject(data);
		//int userId = jsonObject.getIntValue("userId");
		int userId = (int)request.getAttribute("userId");
		int subjectId = jsonObject.getIntValue("subjectId");
		int subjectType = jsonObject.getIntValue("subjectType");
		int freshenType = jsonObject.getIntValue("freshenType");
		String keyWord = jsonObject.getString("keyWord");
		
		//加载某人，某类，之前后包含关键字的帖子列表
		List<Subject> postList =subjectService.showList(userId, subjectId, subjectType, freshenType);
		
		List<Subject> newList = new ArrayList<Subject>();
		for(Subject temp:postList){
			newList.add(SubjectToResponse.transfer(temp, userId));
		
		}
		//帖子数添加数目
	
		subjectService.addViewCount();
		response.setSubjectList(newList);
		response.setResponseCode(0);
		response.setDescription("获取列表成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 删除id对应的帖子
	 * 
	 * */
	
	@RequestMapping(value="/delete",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String idPost(@RequestParam String data,HttpServletRequest request){
	
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PostListResponseCode response = new PostListResponseCode();
		int subjectId = jsonObject.getIntValue("subjectId");

		subjectService.delete(subjectId);
		response.setResponseCode(0);
		response.setDescription("删帖成功");
		return JSON.toJSONString(response);
	}
	
	/*
	 * 加精帖子
	 * 
	 * */
	
	@RequestMapping(value="/perfect",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String perfect(@RequestParam String data,HttpServletRequest request){
	
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PostListResponseCode response = new PostListResponseCode();
		int subjectId = jsonObject.getIntValue("subjectId");

		subjectService.perfect(subjectId);
		response.setResponseCode(0);
		response.setDescription("加精成功");
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 查询精华帖子列表
	 * 
	 * */
	
	@RequestMapping(value="/perfectList",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String perfectList(@RequestParam String data,HttpServletRequest request){
	
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PostListResponseCode response = new PostListResponseCode();
	
		int subjectId = jsonObject.getIntValue("subjectId");
		int freshenType = jsonObject.getIntValue("freshenType");

		List<Subject> subjectList = subjectService.perfectList(subjectId, freshenType);
		response.setResponseCode(0);
		response.setDescription("查询精华帖子成功");
		response.setSubjectList(subjectList);
		return JSON.toJSONString(response);
	}
	
	
	/*
	 * 查询我的帖子列表
	 * 
	 * */
	
	@RequestMapping(value="/selfSubject",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selfSubject(@RequestParam String data,HttpServletRequest request){
	
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PostListResponseCode response = new PostListResponseCode();
		int subjectId = jsonObject.getIntValue("subjectId");
		int freshenType = jsonObject.getIntValue("freshenType");
		int userId =(int) request.getAttribute("userId");
		List<Subject> subjectList = subjectService.selfSubject(userId, subjectId, freshenType);
		List<Subject> newList = new ArrayList<Subject>();
		for(Subject temp:subjectList){
			newList.add(SubjectToResponse.transfer(temp, userId));
		}
		
		response.setResponseCode(0);
		response.setDescription("查询我的问题成功");
		response.setSubjectList(newList);
		return JSON.toJSONString(response);
	}
	
	/*
	 * 查询我的帖子列表
	 * 
	 * */
	
	@RequestMapping(value="/detail",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String detail(HttpServletRequest request){

		int subjectId =Integer.valueOf(request.getParameter("id"));
		PostListResponseCode response = new PostListResponseCode();
		Subject subject = subjectService.subjectDetail(subjectId);
		int userId =(int) request.getAttribute("userId");

		response.setResponseCode(0);
		response.setDescription("查询我的问题成功");
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList.add(SubjectToResponse.transfer(subject, userId));
		response.setSubjectList(subjectList);
		
		return JSON.toJSONString(response);
	}
	
	/*
	 * 查询我的帖子列表
	 * 
	 * */
	@RequestMapping(value="/details",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String details(HttpServletRequest request){

		int subjectId =Integer.valueOf(request.getParameter("id"));
		PostListResponseCode response = new PostListResponseCode();
		
		Subject subject = subjectService.subjectDetail(subjectId);
		int userId =(int) request.getAttribute("userId");
		
		response.setResponseCode(0);
		response.setDescription("查询我的问题成功");
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList.add(SubjectToResponse.transfer(subject, userId));
		response.setSubjectList(subjectList);
		
		return JSON.toJSONString(response);
	}

}