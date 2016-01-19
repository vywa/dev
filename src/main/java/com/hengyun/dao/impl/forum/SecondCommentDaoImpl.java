package com.hengyun.dao.impl.forum;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.SecondCommentDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.SecondComment;


/*
 *   二次回复
 * */

public class SecondCommentDaoImpl extends BaseMongodbDaoImpl<SecondComment,Integer> implements SecondCommentDao{


	@Override
	protected Class<SecondComment> getEntityClass() {
		// TODO Auto-generated method stub
		return SecondComment.class;
	}

	public int addComment(SecondComment comment,int commentId) {
		// TODO Auto-generated method stub
	
		Query query = Query.query(Criteria.where("commentID").gt(0));
        Update update = new Update();
        update.inc("commentID", 1);
        
     
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int userId = index.getCommentID();
		comment.setId(userId);
		comment.setReplyToId(commentId);
		comment.setReplyTime(new Date());
		this.mongoTemplate.save(comment);
		 return userId;
	}

	

    
}
