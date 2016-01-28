package com.hengyun.dao.impl.forum;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.ReplySubjectDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.ReplySubject;


/*
 *  帖子
 * */

public class ReplySubjectDaoImpl extends BaseMongodbDaoImpl<ReplySubject,Integer> implements ReplySubjectDao{


	@Override
	protected Class<ReplySubject> getEntityClass() {
		// TODO Auto-generated method stub
		return ReplySubject.class;
	}

	public int post(ReplySubject post) {
		// TODO Auto-generated method stub
	
		Query query = Query.query(Criteria.where("commentId").gt(0));
        Update update = new Update();
        update.inc("commentId", 1);
        
     
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int sid = index.getCommentID();
		post.setSubjectId(sid);
		this.mongoTemplate.save(post);

		 return sid;
	}



    
}
