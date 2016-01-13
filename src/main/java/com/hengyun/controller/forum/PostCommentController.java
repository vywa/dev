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
import com.hengyun.domain.forum.PostComment;
import com.hengyun.service.forum.ForumPostService;
import com.hengyun.service.forum.PostCommentService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  回复管理
 * */
@Controller  
@RequestMapping("reply")  
public class PostCommentController {   
    @Resource
    private LoginInfoService loginInfoService;
    
	@Resource
	private ForumPostService forumPostService;
	
	@Resource 
	private PostCommentService postCommentService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addComment(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		PostComment comment = JSON.toJavaObject(jsonObject, PostComment.class);
		String idStr = request.getParameter("postId");
	//	String tocken = request.getParameter("tocken");
		if(postCommentService.comment(comment, Integer.valueOf(idStr))>0){
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
		List<PostComment> commentList = postCommentService.show();
		   return JSON.toJSONString(commentList);
		
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
		String idStr = request.getParameter("commentId");
		postCommentService.deleteById(Integer.valueOf(idStr));
		response.setCode("210");
		response.setMessage("delete success");
		return JSON.toJSONString(response);
	}
	
}