package com.hengyun.dao.impl.forum;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.SubjectDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.domain.forum.Subject;


/*
 *  帖子
 * */

public class SubjectDaoImpl extends BaseMongodbDaoImpl<Subject,Integer> implements SubjectDao{


	@Override
	protected Class<Subject> getEntityClass() {
		// TODO Auto-generated method stub
		return Subject.class;
	}

	public int post(Subject post) {
		// TODO Auto-generated method stub
	
		Query query = Query.query(Criteria.where("postID").gt(0));
        Update update = new Update();
        update.inc("postID", 1);

		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int sid = index.getPostID();
		System.out.println(sid);
		post.setSubjectId(sid);
		this.mongoTemplate.save(post);

		 return sid;
	}

	@Override
	public int reply(int subjectId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("subjectId").is(subjectId));
		  Update update = new Update();
	        update.inc("replyNum", 1);
	        Subject subject =  this.mongoTemplate.findAndModify(query, update, Subject.class);
	        
	           return subject.getReplyNum();
	}



    
}
