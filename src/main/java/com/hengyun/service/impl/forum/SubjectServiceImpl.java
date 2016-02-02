package com.hengyun.service.impl.forum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.SubjectDao;
import com.hengyun.domain.forum.Subject;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;

/*
 *  　个人信息管理
 * */

public class SubjectServiceImpl extends BaseServiceImpl<Subject,Integer> implements SubjectService{

	@Resource
	private SubjectDao subjectDao;
	
	@Resource 
	private InformationService informationService;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	
	@Resource
	private UserAccountService userAccountService;



	//更新资料
	public int update(Subject forumPost,String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Query query = Query.query(Criteria.where("userId").is(userId));
			Update update = Update.update("title","title").set("title", "hello");
			subjectDao.updateFirst(query, update);
			return 0;
		} 
			return -1;
	
	}

	//发送帖子
	public int  post(Subject forumPost,String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline( tocken);
		if(userId>0){
			
			Information info = new Information();
			Query query = Query.query(Criteria.where("userId").is(userId));
			info = informationService.queryOne(query);
			
			forumPost.setAuthorPhotoImgUrl(info.getIconUrl());
		
			forumPost.setLikeCount(0);
			forumPost.setPublishTime(String.valueOf(new Date().getTime()));
			String imageUrl = info.getIconUrl();
			forumPost.setAuthorPhotoImgUrl(imageUrl);
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
			String dateTime = dateFm.format(new java.util.Date());
			forumPost.setPublishTime(dateTime);
			
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
			//设置用户昵称
			forumPost.setAuthor(forumName);
		
			int postId = subjectDao.post(forumPost);
			return postId;
		}
		return -1;
	}


	public List<Subject> showList( int userId,int subjectId,int subjectType ,int freshenType) {
		// TODO Auto-generated method stub
		List<Subject> forumPost=null;
			Query query = new Query();
			Criteria criteria =Criteria.where("subjectType").is(subjectType).andOperator(Criteria.where("subjectId").gt(subjectId));
			  query.addCriteria(criteria).with(new Sort(Direction.ASC, "subjectId"));
				Query query2 = new Query();
				Criteria criteria2 =Criteria.where("subjectType").is(subjectType).andOperator(Criteria.where("subjectId").lt(subjectId));
				  query2.addCriteria(criteria2).with(new Sort(Direction.DESC, "subjectId"));
				  
			if(freshenType== -1){
				//forumPost=subjectDao.queryList(query);
				forumPost = subjectDao.getPage(query, 0, 10);
			}
			else if(freshenType==1){
				//forumPost=subjectDao.queryList(query);
				 forumPost = subjectDao.getPage(query2, 0, 10);
			}
			return forumPost;
	
	}

	
	public List<Subject> show(String author ) {
		// TODO Auto-generated method stub
	
			Query query = Query.query(Criteria.where("author").is(author));
			List<Subject> forumPost = subjectDao.queryList(query);
			return forumPost;
	
	}

	public List<Subject> showAll() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").exists(true));
		return subjectDao.queryList(query);
		
	}

	//删帖
	@Override
	public void delete(int subjectId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("subjectId").is(subjectId));
		Subject subject = subjectDao.queryOne(query);
		subjectDao.delete(subject);
	}

}
