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
import com.hengyun.dao.forum.SubjectDao;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.ForumResponseCode;
import com.hengyun.domain.forum.ReplyListResponseCode;
import com.hengyun.domain.forum.ReplySubject;
import com.hengyun.domain.forum.Subject;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.forum.ReplySubjectService;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("replysubject")  
public class ReplySubjectController {   
    @Resource
    private LoginInfoService loginInfoService;
    @Resource
    private UserAccountService userAccountService;
	@Resource
	private ReplySubjectService replySubjectService;
	@Resource
	private InformationService informationService;
	@Resource
	private SubjectDao subjectDao;
	
	
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
			String forumName = null;
			UserAccount account = userAccountService.queryById(userId);
			String trueName = account.getUsername();
			String mobilephone =account.getMobilephone();
			String email =account.getEmail();
			String qq = account.getQQ();
			String weiChat = account.getWeiChat();
			String weiBo = account.getWeiBo();
		
			if(trueName!=null){
				forumName=trueName;
			} else if(mobilephone!=null){
				forumName=mobilephone;
			} else if(email!=null){
				forumName = email;
			} else if(qq!=null){
				forumName = qq;
			} else if(weiChat!=null){
				forumName = weiChat;
			} else if(weiBo !=null){
				forumName = weiBo;
			} 
			post.setReplyAuthor(forumName);
			post.setReplyAuthorPhotoUrl(info.getIconUrl());
			post.setUserId(userId);
		
		//	post.setReplyId(userId);
		
			replySubjectService.post(post, userId);
			//更新帖子回复数目
			Query query2 = Query.query(Criteria.where("subjectId").is(post.getSubjectId()));
		//	Subject subject = subjectService.queryOne(query2);
			//int count = subject.getReplyNum();
			//count = count + 1;
		
			//Update upate2 = Update.update("replyNum", count); 
		//	subjectService.updateFirst(query, upate2);
			int num = subjectDao.reply(post.getSubjectId());
			System.out.println("帖子 "+post.getSubjectId()+" 回复数量为"+num);
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
			return JSON.toJSONString(response);
		}
	
}