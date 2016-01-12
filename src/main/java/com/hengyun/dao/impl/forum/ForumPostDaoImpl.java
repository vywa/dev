package com.hengyun.dao.impl.forum;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.ForumPostDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.forum.ForumPost;
import com.hengyun.domain.information.Information;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/*
 *  上传文件
 * */

public class ForumPostDaoImpl extends BaseMongodbDaoImpl<ForumPost,Integer> implements ForumPostDao{


	@Override
	protected Class<ForumPost> getEntityClass() {
		// TODO Auto-generated method stub
		return ForumPost.class;
	}

	public int post(ForumPost post) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("postID").gt(0));
        Update update = new Update();
        update.inc("postID", 1);
        
       // this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		int userId = index.getPostID();
		post.setId(userId);
		this.mongoTemplate.save(post);

		 return userId;
	}

    
}
