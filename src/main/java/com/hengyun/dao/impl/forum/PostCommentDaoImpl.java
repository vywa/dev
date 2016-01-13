package com.hengyun.dao.impl.forum;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.PostCommentDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.PostComment;


/*
 *  回复
 * */

public class PostCommentDaoImpl extends BaseMongodbDaoImpl<PostComment,Integer> implements PostCommentDao{


	@Override
	protected Class<PostComment> getEntityClass() {
		// TODO Auto-generated method stub
		return PostComment.class;
	}

	public int addComment(PostComment comment,int postId) {
		// TODO Auto-generated method stub
	
		Query query = Query.query(Criteria.where("commentID").gt(0));
        Update update = new Update();
        update.inc("commentID", 1);
        
     
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int userId = index.getCommnetId();
		comment.setId(userId);
		comment.setReplyToId(postId);
		this.mongoTemplate.save(comment);
		 return userId;
	}

	

    
}
