package com.hengyun.service.impl.friendcircle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.friendcircle.FriendCircleDao;
import com.hengyun.domain.friendcircle.Friend;
import com.hengyun.domain.friendcircle.FriendCircle;
import com.hengyun.service.friendcircle.FriendCircleService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　病历信息管理
 * */

public class FriendCircleServiceImpl extends BaseServiceImpl<FriendCircle,Integer> implements FriendCircleService{

	@Resource 
	private FriendCircleDao friendCircleDao;

	



	public List<FriendCircle> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Friend> getDocters(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle =    friendCircleDao.queryOne(query);
		return circle.getDocters();
		
	}



	public List<Friend> getPatients(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle =    friendCircleDao.queryOne(query);
		return circle.getPatients();
	}



	public List<Friend> getUnhandled(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle =    friendCircleDao.queryOne(query);
		return circle.getUnhandlerFriendList();
	}



	public void addFriend(Friend friend,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle =    friendCircleDao.queryOne(query);
		if(friend.getRelation().equals("patient")){
			List<Friend> patient = circle.getPatients();
			patient.add(friend);
			circle.setPatients(patient);
		} else if(friend.getRelation().equals("docter")){
			List<Friend> docter = circle.getDocters();
			docter.add(friend);
			circle.setPatients(docter);
		} else if(friend.getRelation().equals("friend")){
			List<Friend> friends = circle.getFriendList();
			friends.add(friend);
			circle.setPatients(friends);
		}
		friendCircleDao.save(circle);
	}



	public void deleteFriend(Friend friend ,int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		Update update = null;
		FriendCircle circle =    friendCircleDao.queryOne(query);
		if(friend.getRelation().equals("patient")){
			List<Friend> patient = circle.getPatients();
			patient.remove(patient);
			circle.setPatients(patient);
			 update = Update.update("patients",patient );
		} else if(friend.getRelation().equals("docter")){
			List<Friend> docter = circle.getDocters();
			docter.remove(friend);
		
			 update = Update.update("docters",docter );
		} else if(friend.getRelation().equals("friend")){
			List<Friend> friends = circle.getFriendList();
			friends.remove(friend);
			circle.setPatients(friends);
			 update = Update.update("friendList",friends );
		}
		
		friendCircleDao.updateFirst(query, update);
	}


	public void setFriend(Friend friend, int userId) {
		// TODO Auto-generated method stub
		
	}



	public void addUnhandled(Friend friend, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle =    friendCircleDao.queryOne(query);
		if(circle==null){
			 circle = new FriendCircle();
			 circle.setUserId(userId);
		}
		List<Friend> unhandle = circle.getUnhandlerFriendList();
		if(unhandle==null){
			unhandle=new ArrayList<Friend>();
		} 
		unhandle.add(friend);
		circle.setUnhandlerFriendList(unhandle);
		friendCircleDao.save(circle);
	}



	public void handle(Friend friend, int userId) {
		// TODO Auto-generated method stub
		
	}


	
	

}
