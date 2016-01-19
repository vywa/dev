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
import com.hengyun.domain.forum.SecondComment;
import com.hengyun.service.forum.ForumPostService;
import com.hengyun.service.forum.PostCommentService;
import com.hengyun.service.forum.SecondCommentService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  二次回复管理
 * */
@Controller  
@RequestMapping("recomment")  
public class SecondCommentController {   
    @Resource
    private LoginInfoService loginInfoService;
    
	@Resource
	private ForumPostService forumPostService;
	
	@Resource 
	private PostCommentService postCommentService;
	
	@Resource 
	private SecondCommentService secondCommentService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		SecondComment comment = JSON.toJavaObject(jsonObject, SecondComment.class);
		String idStr = request.getParameter("commentID");
		String tocken = request.getParameter("tocken");
		int userId = loginInfoService.isOnline( tocken);
		if(userId>0){
			comment.setReplyerId(userId);
		
			if(secondCommentService.post(comment, Integer.valueOf(idStr))>0){
				response.setCode("209");
				response.setMessage("post success");
			} else{
				response.setCode("111");
				response.setMessage("post failure");
			}
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
	public String showComment(HttpServletRequest request){
		List<SecondComment> commentList = secondCommentService.show();
		   return JSON.toJSONString(commentList);
		
	}
	
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteComment(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
	
		String tocken = request.getParameter("tocken");
		String idStr = request.getParameter("commentID");
		//删除对应的评论
		secondCommentService.deleteById(Integer.valueOf(idStr));
		response.setCode("210");
		response.setMessage("delete success");
		return null;
	}
	
}