package com.hengyun.controller.forum;

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
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.service.forum.ForumPostService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("post")  
public class ForumPostController {   
    @Resource
    private LoginInfoService loginInfoService;
    
	@Resource
	private ForumPostService forumPostService;
	
	//发送帖子
	@RequestMapping("/add")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		ForumPost post = JSON.toJavaObject(jsonObject, ForumPost.class);
	
		String tocken = request.getParameter("tocken");
		
		
		if(forumPostService.post(post, tocken)>0){
			response.setCode("209");
			response.setMessage("post success");
		} else{
			response.setCode("111");
			response.setMessage("post failure");
		}
		
		return JSON.toJSONString(response);
	}
	//更新帖子
	@RequestMapping("/update")
	@ResponseBody
	public String updateHospital(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject = JSONObject.parseObject(data);
		ForumPost post = JSON.toJavaObject(jsonObject, ForumPost.class);
		Query query = Query.query(Criteria.where("id").is(post.getId()));
		Update update = Update.update("title",post.getTitle()).set("theme", post.getTheme());
		forumPostService.updateInser(query, update);
	//	hospitalService.save(hospital);
		
		
		ResponseCode response = new ResponseCode();
		response.setCode("206");
		response.setMessage("update success");
		 return JSON.toJSONString(response);
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setPost(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showPost(HttpServletRequest request){
	
		List<ForumPost> postList = forumPostService.showAll();

		return JSON.toJSONString(postList);
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryPost(@RequestParam String data,HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
	
		List<ForumPost> postList = forumPostService.show(tocken);

		return JSON.toJSONString(postList);
	}
	
	@RequestMapping("/queryList")
	@ResponseBody
	public String queryList(@RequestParam String data,HttpServletRequest request){
		//String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
		int subjectId = jsonObject.getIntValue("subjectId");
		int subjectType = jsonObject.getIntValue("subjectType");
		int freshenType = jsonObject.getIntValue("freshenType");
		String keyWord = jsonObject.getString("keyWord");
		
		//加载某人，某类，之前后包含关键字的帖子列表
		List<ForumPost> postList = forumPostService.showAll();

		return JSON.toJSONString(postList);
	}
	
	//某个id对应的帖子
	@RequestMapping("/index")
	@ResponseBody
	public String idPost(@RequestParam String data,HttpServletRequest request){
	//	String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
		int id = jsonObject.getIntValue("id");
	ForumPost post = forumPostService.queryById(id);

		return JSON.toJSONString(post);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editPost(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deletePost(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		
//		String tocken = request.getParameter("tocken");
		int id = jsonObject.getIntValue("id");
		forumPostService.deleteById(id);
		response.setCode("210");
		response.setMessage("delete success");
		return JSON.toJSONString(response);
	}
	
	
}