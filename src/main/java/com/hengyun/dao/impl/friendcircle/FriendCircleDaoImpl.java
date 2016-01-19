package com.hengyun.dao.impl.friendcircle;


import com.hengyun.dao.friendcircle.FriendCircleDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.friendcircle.FriendCircle;


/*
 *  朋友圈
 * */

public class FriendCircleDaoImpl extends BaseMongodbDaoImpl<FriendCircle,Integer> implements FriendCircleDao{


	@Override
	protected Class<FriendCircle> getEntityClass() {
		// TODO Auto-generated method stub
		return FriendCircle.class;
	}



}
