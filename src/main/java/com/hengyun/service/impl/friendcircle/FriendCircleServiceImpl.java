package com.hengyun.service.impl.friendcircle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.friendcircle.FriendCircleDao;
import com.hengyun.domain.friendcircle.Friend;
import com.hengyun.domain.friendcircle.FriendCircle;
import com.hengyun.domain.information.Information;
import com.hengyun.service.friendcircle.FriendCircleService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;

/*
 *  　病历信息管理
 * */

public class FriendCircleServiceImpl extends BaseServiceImpl<FriendCircle, Integer> implements FriendCircleService {

	@Resource
	private FriendCircleDao friendCircleDao;
	@Resource
	private InformationService informationService;

	public List<FriendCircle> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Friend> getDocters(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle = friendCircleDao.queryOne(query);
		return circle.getDocters();

	}

	public List<Friend> getPatients(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle = friendCircleDao.queryOne(query);
		return circle.getPatients();
	}

	public List<Friend> getUnhandled(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		FriendCircle circle = friendCircleDao.queryOne(query);
		return circle.getUnhandlerFriendList();
	}

	public void addFriend(Friend friend, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("unhandlerFriendList.friendId").is(friend.getFriendId()));
		Query query2 = Query.query(Criteria.where("userId").is(userId));
		Query query3 = Query.query(Criteria.where("userId").is(friend.getFriendId()));
		FriendCircle circle = friendCircleDao.queryOne(query);
		if (friend.getRelation().equals("patient")) {
			// 获取病人列表
			List<Friend> patient = circle.getPatients();
			if (patient == null) {
				patient = new ArrayList<Friend>();
			}
			// 删除未处理表里的好友
			List<Friend> unhandled = circle.getUnhandlerFriendList();
			if (unhandled != null) {
				Iterator<Friend> iterator = unhandled.iterator();
				while (iterator.hasNext()) {
					Friend unhandle = iterator.next();
					if (unhandle.getFriendId() == friend.getFriendId()) {
						iterator.remove();

					}
				}

			} else {
				unhandled = new ArrayList<Friend>();
			}
			patient.add(friend);
			Update update = Update.update("patients", patient).set("unhandlerFriendList", unhandled);
			friendCircleDao.updateInser(query2, update);
			// 更新病人的好友表中的值
			FriendCircle circle2 = friendCircleDao.queryOne(query3);
			List<Friend> docterList = circle2.getDocters();
			if (docterList == null) {
				docterList = new ArrayList<Friend>();
			}
			Information info = informationService.query(userId);
			Friend docter = new Friend();
			docter.setFriendId(info.getUserId());
			docter.setFriendName(info.getTrueName());
			docter.setRelation("docter");
			docterList.add(docter);
			Update update2 = Update.update("docters", docterList);
			friendCircleDao.updateInser(query3, update2);
		} else if (friend.getRelation().equals("docter")) { // 处理医生的好友请求
			List<Friend> docter = circle.getDocters();
			if (docter == null) {
				docter = new ArrayList<Friend>();
			}
			List<Friend> unhandled = circle.getUnhandlerFriendList();

			if (unhandled != null) {
				Iterator<Friend> iterator = unhandled.iterator();
				while (iterator.hasNext()) {
					Friend unhandle = iterator.next();
					if (unhandle.getFriendId() == friend.getFriendId())
						iterator.remove();
				}

			} else {
				unhandled = new ArrayList<Friend>();
			}
			docter.add(friend);
			Update update = Update.update("docters", docter).set("unhandlerFriendList", unhandled);
			friendCircleDao.updateInser(query2, update);
			// 更新医生的病人列表
			FriendCircle circle2 = friendCircleDao.queryOne(query3);
			if(circle2==null){
				circle2 = new FriendCircle();
			}
			List<Friend> patientList = circle2.getDocters();
			if (patientList == null) {
				patientList = new ArrayList<Friend>();
			}
			Information info = informationService.query(userId);
			Friend patient = new Friend();
			patient.setFriendId(info.getUserId());
			patient.setFriendName(info.getTrueName());
			patient.setRelation("patient");
			patientList.add(patient);
			Update update2 = Update.update("patients", patientList);
			friendCircleDao.updateInser(query3, update2);
		} else if (friend.getRelation().equals("friend")) {
			List<Friend> friends = circle.getFriendList();
			if (friends == null) {
				friends = new ArrayList<Friend>();
			}
			List<Friend> unhandled = circle.getUnhandlerFriendList();
			if (unhandled != null) {
				Iterator<Friend> iterator = unhandled.iterator();
				while (iterator.hasNext()) {
					Friend unhandle = iterator.next();
					if (unhandle.getFriendId() == friend.getFriendId())
						iterator.remove();
				}

			} else {
				unhandled = new ArrayList<Friend>();
			}
			friends.add(friend);
			Update update = Update.update("friendList", friends).set("unhandlerFriendList", unhandled);
			friendCircleDao.updateInser(query2, update);
			// 更新对方好友的列表内容
			FriendCircle circle2 = friendCircleDao.queryOne(query3);
			List<Friend> friendList = circle2.getFriendList();
			Information info = informationService.query(userId);
			Friend friend2 = new Friend();
			friend2.setFriendId(info.getUserId());
			friend2.setFriendName(info.getTrueName());
			friend2.setRelation("friend");
			friendList.add(friend2);
			Update update2 = Update.update("friendList", friendList);
			friendCircleDao.updateInser(query3, update2);
		}
	}

	public void deleteFriend(Friend friend, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		Update update = null;
		FriendCircle circle = friendCircleDao.queryOne(query);
		if (friend.getRelation().equals("patient")) {
			List<Friend> patient = circle.getPatients();
			patient.remove(patient);

			update = Update.update("patients", patient);
		} else if (friend.getRelation().equals("docter")) {
			List<Friend> docter = circle.getDocters();
			docter.remove(friend);

			update = Update.update("docters", docter);
		} else if (friend.getRelation().equals("friend")) {
			List<Friend> friends = circle.getFriendList();
			friends.remove(friend);

			update = Update.update("friendList", friends);
		}

		friendCircleDao.updateFirst(query, update);
	}

	public void setFriend(Friend friend, int userId) {
		// TODO Auto-generated method stub

	}

	public void addUnhandled(Friend friend, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));

		FriendCircle circle = friendCircleDao.queryOne(query);
		if (circle == null) {
			circle = new FriendCircle();
			circle.setUserId(userId);
		}
		List<Friend> unhandle = circle.getUnhandlerFriendList();
		if (unhandle == null) {
			unhandle = new ArrayList<Friend>();
		} 
		unhandle.add(friend);
		Update update = Update.update("unhandlerFriendList", unhandle);
		friendCircleDao.updateInser(query, update);

	}

	public void handle(Friend friend, int userId) {
		// TODO Auto-generated method stub

	}

	public int isDocter(int docterId, int patientId) {
		// TODO Auto-generated method stub
		Query query = Query.query(
				Criteria.where("userId").is(patientId).andOperator(Criteria.where("docters.friendId").is(docterId)));
		FriendCircle circle = friendCircleDao.queryOne(query);
		if (circle == null) {
			return -1;
		} else {
			return docterId;
		}
	}

	public int isPatient(int patientId, int docterId) {
		// TODO Auto-generated method stub
		Query query = Query.query(
				Criteria.where("userId").is(docterId).andOperator(Criteria.where("patients.friendId").is(patientId)));
		FriendCircle circle = friendCircleDao.queryOne(query);
		if (circle == null) {
			return -1;
		} else {
			return patientId;
		}
	}

	public int isFriend(int request, int response) {
		// TODO Auto-generated method stub
		Query query = Query.query(
				Criteria.where("userId").is(response).andOperator(Criteria.where("friendList.friendId").is(request)));
		FriendCircle circle = friendCircleDao.queryOne(query);
		if (circle == null) {
			return -1;
		} else {
			return request;
		}
	}

}
