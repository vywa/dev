package com.hengyun.service.impl.forum;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.SubjectAvailableListDao;
import com.hengyun.domain.forum.SubjectAvailableList;
import com.hengyun.service.forum.SubjectAvailableListService;
import com.hengyun.service.friendcircle.mysql.RosterService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 上午11:01:28
* 朋友圈权限管理列表业务类
*/
public class SubjectAvailableListServiceImpl extends BaseServiceImpl<SubjectAvailableList,Integer> implements SubjectAvailableListService{

	private static final Logger log = LoggerFactory.getLogger(SubjectAvailableListServiceImpl.class);
	@Resource
	private SubjectAvailableListDao subjectAvailableListDao;

	@Resource
	private RosterService rosterService;
	/*
	 * 
	 *  初始化用户的可见列表和关注列表
	 * 
	 * */
	@Override
	public void init(int userId) {
		// TODO Auto-generated method stub
		List<Integer> list = rosterService.getFriendList(String.valueOf(userId));
		SubjectAvailableList sal = new SubjectAvailableList();
		sal.setAuthorId(userId);
		sal.setAvailable(list);
		sal.setSubscribe(list);
		sal.setPublicSee(true);
		subjectAvailableListDao.save(sal);
	}

	/*
	 * 
	 *  更新可见列表
	 * 
	 * */
	@Override
	public int updateAvailable(SubjectAvailableList available) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(available.getAuthorId()));
		Update update = Update.update("available", available.getAvailable());
		subjectAvailableListDao.updateFirst(query, update);
		return 0;
	}

	/*
	 * 
	 *  更新关注列表
	 * 
	 * */
	@Override
	public int updateSubscribe(SubjectAvailableList available) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(available.getAuthorId()));
		Update update = Update.update("subscrible", available.getSubscribe());
		subjectAvailableListDao.updateFirst(query, update);
		return 0;
	}

	/*
	 * 
	 *  查询可见列表
	 * 
	 * */
	@Override
	public List<Integer> queryAvailable(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("authorId").is(userId));
		
		SubjectAvailableList subjectAvailableList = subjectAvailableListDao.queryOne(query);
		if(subjectAvailableList==null){
			init(userId);
			 subjectAvailableList = subjectAvailableListDao.queryOne(query);
		}
		if(subjectAvailableList==null){
			return null;
		}
			
	
		return subjectAvailableList.getAvailable();
	}

	/*
	 * 
	 *  查询关注列表
	 * 
	 * */
	@Override
	public List<Integer> querySubscribe(int userId) {
		// TODO Auto-generated method stub
	Query query = Query.query(Criteria.where("userId").is(userId));
		
		SubjectAvailableList subjectAvailableList = subjectAvailableListDao.queryOne(query);
		
		return subjectAvailableList.getSubscribe();
	}

}
