package com.hengyun.dao.impl.forum;

import java.io.InputStream;

import com.hengyun.dao.forum.MultiMediaDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.forum.MultiMedia;
import com.hengyun.domain.information.Icon;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/*
 *   多媒体信息
 * */

public class MultiMediaDaoImpl extends BaseMongodbDaoImpl<MultiMedia,Integer> implements MultiMediaDao{


	@Override
	protected Class<MultiMedia> getEntityClass() {
		// TODO Auto-generated method stub
		return MultiMedia.class;
	}

	
    public void save(InputStream in,String filename){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(MultiMedia.class));
        GridFSInputFile gridFSInputFile =gridFS.createFile(in, filename);  
      
        gridFSInputFile.save();  
        
        return;  
    }  
	
	 /** 
     * 据id返回文件 
     * 
     */  
    public GridFSDBFile getById(Object id){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(MultiMedia.class));
	
        DBObject query  = new BasicDBObject("_id", id);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        return gridFSDBFile;  
    }  
       
    /** 
     * 据文件名返回文件，只返回第一个 
     *
     */  
    public GridFSDBFile getByFileName(String fileName){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(MultiMedia.class));
	
        DBObject query  = new BasicDBObject("filename", fileName);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        return gridFSDBFile;  
    }  
    
}
