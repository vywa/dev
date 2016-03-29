package com.hengyun.service.impl.forum;

import java.util.ArrayList;
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
import com.hengyun.service.forum.SubjectAvailableListService;
import com.hengyun.service.forum.SubjectService;
import com.hengyun.service.friendcircle.mysql.RosterService;
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
	private SubjectAvailableListService subjectAvailableListService;
	
	@Resource
	private UserAccountService userAccountService;

	@Resource
	private RosterService rosterService;

	/*
	 * 更新资料
	 * */
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

	/*
	 * 	
	 * 	发送帖子
	 * 
	 * */
	public int  post(Subject forumPost,int userId) {
		// TODO Auto-generated method stub
			Information info = new Information();
	
			Query query = Query.query(Criteria.where("userId").is(userId));
			info = informationService.queryOne(query);
			forumPost.setAuthorPhotoImgUrl(info.getIconUrl());
			forumPost.setLikeCount(0);
			forumPost.setPublishTime(new Date().getTime());
			forumPost.setAuthorId(userId);
			String imageUrl = info.getIconUrl();
			forumPost.setAuthorPhotoImgUrl(imageUrl);
		
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

	/*
	 * 	
	 * 	发送朋友圈
	 * 
	 * */
	public int  send(Subject forumPost,int userId) {
		// TODO Auto-generated method stub
			Information info = new Information();
			List<Integer> available =subjectAvailableListService.queryAvailable(userId);
			Query query = Query.query(Criteria.where("authorId").is(userId));
			info = informationService.queryOne(query);
			forumPost.setAuthorPhotoImgUrl(info.getIconUrl());
			forumPost.setLikeCount(0);
			forumPost.setPublishTime(new Date().getTime());
			//设置可见列表
			forumPost.setAvailable(available);	
			String imageUrl = info.getIconUrl();
			forumPost.setAuthorPhotoImgUrl(imageUrl);
		
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

	
	public List<Subject> showList( int userId,int subjectId,int subjectType ,int freshenType) {
		// TODO Auto-generated method stub
			List<Subject> forumPost=null;
		
			//按照帖子id升序排列
			Query query = new Query();
			Criteria criteria =Criteria.where("subjectType").is(subjectType).andOperator(Criteria.where("subjectId").gt(subjectId));
			  query.addCriteria(criteria).with(new Sort(Direction.ASC, "subjectId"));
			  //按照帖子id降序排列
				Query query2 = new Query();
				Criteria criteria2 =Criteria.where("subjectType").is(subjectType).andOperator(Criteria.where("subjectId").lt(subjectId));
				 query2.addCriteria(criteria2).with(new Sort(Direction.DESC, "subjectId"));
				  
			if(freshenType== -1){
			
				forumPost = subjectDao.getPage(query, 0, 10);
			}
			else if(freshenType==1){
				
				 forumPost = subjectDao.getPage(query2, 0, 10);
			}
			return forumPost;
	
	}

	/*
	 *  显示所有贴子
	 * */
	public List<Subject> showAll() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").exists(true));
		return subjectDao.queryList(query);
		
	}

	/*
	 * 
	 * 	删除某个帖子
	 * 
	 * */
	@Override
	public void delete(int subjectId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("subjectId").is(subjectId));
		Subject subject = subjectDao.queryOne(query);
		subjectDao.delete(subject);
	}

	/*
	 * 
	 *  显示所有好友的帖子
	 * 
	 * */
	@Override
	public List<Subject> friendsSubject(int userId,int subjectId,int freshenType) {
		// TODO Auto-generated method stub
		//获取关注的好友列表
		List<Integer> subscribeList = subjectAvailableListService.querySubscribe(userId);

		List<Subject> forumPost= new ArrayList<Subject>();
		
		Query query = new Query();
		//帖子作者在关注列表中
		Criteria criteria =Criteria.where("authorId").in(subscribeList).andOperator(Criteria.where("subjectId").gt(subjectId));
		
		  query.addCriteria(criteria).with(new Sort(Direction.ASC, "subjectId"));
			Query query2 = new Query();
			Criteria criteria2 =Criteria.where("authorId").in(subscribeList).andOperator(Criteria.where("subjectId").lt(subjectId));
			  query2.addCriteria(criteria2).with(new Sort(Direction.DESC, "subjectId"));
			  
		if(freshenType== -1){
		
			List<Subject> temps = subjectDao.getPage(query, 0, 10);
			for(Subject temp : temps){
				if(temp.getAvailable().contains(userId)){
					forumPost.add(temp);
				}
			}
		}
		else if(freshenType==1){
			
			 List<Subject> temps = subjectDao.getPage(query2, 0, 10);
			 for(Subject temp : temps){
					if(temp.getAvailable().contains(userId)){
						forumPost.add(temp);
					}
				}
		}
		return forumPost;

	
	}

	/*
	 *  显示某个好友的帖子列表
	 * 
	 * */
	@Override
	public List<Subject> friendSubject(int userId,int friendId,int subjectId,int freshenType) {
		// TODO Auto-generated method stub	/*
	

		List<Subject> forumPost= new ArrayList<Subject>();
		Query query = new Query();
		Criteria criteria =Criteria.where("authorId").is(friendId).andOperator(Criteria.where("subjectId").gt(subjectId));
		
		  query.addCriteria(criteria).with(new Sort(Direction.ASC, "subjectId"));
			Query query2 = new Query();
			Criteria criteria2 =Criteria.where("authorId").is(friendId).andOperator(Criteria.where("subjectId").lt(subjectId));
			  query2.addCriteria(criteria2).with(new Sort(Direction.DESC, "subjectId"));
			  
		if(freshenType== -1){
			List<Subject> temps = subjectDao.getPage(query, 0, 10);
			for(Subject temp : temps){
				if(temp.getAvailable().contains(userId)){
					forumPost.add(temp);
				}
			}
		}
		else if(freshenType==1){	
				List<Subject> temps = subjectDao.getPage(query2, 0, 10);
				for(Subject temp : temps){
					if(temp.getAvailable().contains(userId)){
						forumPost.add(temp);
					}
				}
		}
		return forumPost;

	
	}
	
	/*
	 *  显示某个帖子详细信息
	 * 
	 * */
	@Override
	public Subject subjectDetail(int subjectId) {
		// TODO Auto-generated method stub
		Query query =Query.query(Criteria.where("subjectId").is(subjectId));
		Subject subjectDetail = subjectDao.queryOne(query);

		return subjectDetail;
	}

	/*
	 *  用户查询自己所有帖子
	 * */
	@Override
	public List<Subject> querySelf(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("authorId").is(userId));
		List<Subject> forumPost = subjectDao.queryList(query);
		return forumPost;
	}

}
