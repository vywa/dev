package com.hengyun.controller.forum;

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
		List<ForumPost> postList = forumPostService.show(tocken);

		return JSON.toJSONString(postList);
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
	
		String tocken = request.getParameter("tocken");
		String idStr = request.getParameter("postId");
		forumPostService.deleteById(Integer.valueOf(idStr));
		response.setCode("210");
		response.setMessage("delete success");
		return JSON.toJSONString(response);
	}
	
}