package com.hengyun.controller.forum;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.controller.BaseController;
import com.hengyun.dao.forum.SubjectDao;
import com.hengyun.domain.forum.ForumResponseCode;
import com.hengyun.domain.forum.ReplyListResponseCode;
import com.hengyun.domain.forum.ReplySubject;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.forum.ReplySubjectService;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;
import com.hengyun.util.json.JSONUtil;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("replysubject")  
public class ReplySubjectController extends BaseController{   
	
	private static final Logger log = LoggerFactory.getLogger(ReplySubjectController.class);
	
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
		JSONObject jsonObject =JSONUtil.parseObject(data);
		ReplySubject post = JSONUtil.toJavaObject(jsonObject, ReplySubject.class);
	
		int userId = (int)request.getAttribute("userId");
	
			Information info = new Information();
			Query query = Query.query(Criteria.where("userId").is(userId));
			info = informationService.queryOne(query);
			String forumName = null;
			UserAccount account = userAccountService.queryById(userId);
			Information information = informationService.query(userId);
			String name = information.getTrueName();
			String trueName = account.getUsername();
			String mobilephone =account.getMobilephone();
			String email =account.getEmail();
			String qq = account.getQQ();
			String weiChat = account.getWeiChat();
			String weiBo = account.getWeiBo();
		
			if(trueName!=null){
				forumName=trueName;
			} else if(name!=null){
				forumName=name;
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
		

			replySubjectService.post(post, userId);
			//更新帖子回复数目
			Query query2 = Query.query(Criteria.where("subjectId").is(post.getSubjectId()));
		
			int num = subjectDao.reply(post.getSubjectId());
			log.info("帖子 "+post.getSubjectId()+" 回复数量为"+num);
			response.setResponseCode(0);
			response.setDescription("发送成功");
		

		return JSON.toJSONString(response);
	}
	
	//条件查询帖子列表
		@RequestMapping(value="/queryList",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String queryList(@RequestParam String data,HttpServletRequest request){
		
			ReplyListResponseCode response = new ReplyListResponseCode();
			JSONObject jsonObject =JSONUtil.parseObject(data);
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
		
		//删除帖子的回复
				@RequestMapping(value="/deleteReply",produces = "text/html;charset=UTF-8")
				@ResponseBody
				public String deleteReply(@RequestParam String data,HttpServletRequest request){
				
					ReplyListResponseCode response = new ReplyListResponseCode();
					JSONObject jsonObject =JSONUtil.parseObject(data);
					int userId = jsonObject.getIntValue("userId");
					int subjectId = jsonObject.getIntValue("subjectId");
					int replyId = jsonObject.getIntValue("replyId");
			
					
					//加载某人，某类，之前后包含关键字的帖子列表
					replySubjectService.delete(replyId);
					
					response.setResponseCode(0);
					response.setDescription("删除帖子成功");
					return JSON.toJSONString(response);
				}
				
				//针对回复发表回复
				@RequestMapping(value="/reReply",produces = "text/html;charset=UTF-8")
				@ResponseBody
				public String reReply(@RequestParam String data,HttpServletRequest request){
					
					ReplyListResponseCode response = new ReplyListResponseCode();
					JSONObject jsonObject =JSONUtil.parseObject(data);
					
					ReplySubject post = JSONUtil.toJavaObject(jsonObject, ReplySubject.class);
					int userId = jsonObject.getIntValue("userId");
					int subjectId = jsonObject.getIntValue("subjectId");
					int replyId = jsonObject.getIntValue("replyId");
			
					
					//加载某人，某类，之前后包含关键字的帖子列表
					replySubjectService.save(post);
					
					response.setResponseCode(0);
					response.setDescription("发表帖子成功");
					return JSON.toJSONString(response);
				}
				
				//删除回复发表回复
				@RequestMapping(value="/deletereReply",produces = "text/html;charset=UTF-8")
				@ResponseBody
				public String deletereReply(@RequestParam String data,HttpServletRequest request){
				
					ReplyListResponseCode response = new ReplyListResponseCode();
					JSONObject jsonObject =JSONUtil.parseObject(data);
					
					ReplySubject post = JSONUtil.toJavaObject(jsonObject, ReplySubject.class);
					int userId = jsonObject.getIntValue("userId");
					int subjectId = jsonObject.getIntValue("subjectId");
					int replyId = jsonObject.getIntValue("replyId");
			
					
					//加载某人，某类，之前后包含关键字的帖子列表
					replySubjectService.delete(replyId);
					
					response.setResponseCode(0);
					response.setDescription("删除帖子成功");
					return JSON.toJSONString(response);
				}
	
}