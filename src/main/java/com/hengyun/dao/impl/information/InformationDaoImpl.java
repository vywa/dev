package com.hengyun.dao.impl.information;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.information.Information;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/*
 *  上传文件
 * */

public class InformationDaoImpl extends BaseMongodbDaoImpl<Information,Integer> implements InformationDao{

	private static final Logger Log = LoggerFactory.getLogger(InformationDaoImpl.class);

	@Override
	protected Class<Information> getEntityClass() {
		// TODO Auto-generated method stub
		return Information.class;
	}
	
	public void saveFile(InputStream in){
		
	}

	public void SaveFile(File file, String fileid, String filename) {
		// TODO Auto-generated method stub
		   DB db = mongoTemplate.getDb();
           // 存储fs的根节点
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Information.class));
           GridFSInputFile gfs;
		try {
			gfs = gridFS.createFile(file);
			 gfs.put("filename", fileid);
	           gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
	           gfs.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
          
	}

	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		   DB db = mongoTemplate.getDb();
           // 获取fs的根节点
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Information.class));
           GridFSDBFile dbfile = gridFS.findOne(filename);
           if (dbfile != null) {
               return dbfile;
           }
		return null;
	}

	
    public void save(InputStream in,String filename){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Information.class));

        GridFSInputFile gridFSInputFile =gridFS.createFile(in, "filename");  
        gridFSInputFile.save();  
        Log.info("save  file "+filename+"success");
        return;  
    }  
	
	 /** 
     * 据id返回文件 
     * @param id 
     * @return 
     */  
    public GridFSDBFile getById(Object id){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Information.class));
	
        DBObject query  = new BasicDBObject("_id", id);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        return gridFSDBFile;  
    }  
       
    /** 
     * 据文件名返回文件，只返回第一个 
     * @param fileName 
     * @return 
     */  
    public GridFSDBFile getByFileName(String fileName){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Information.class));
	
        DBObject query  = new BasicDBObject("filename", fileName);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        Log.info("read file "+fileName+"success");
        return gridFSDBFile;  
    }  
    
    /*
	 * 
	 *  查询指定字段
	 * 
	 * */
	@Override
	public List<Information> queryField(Information info) {
		// TODO Auto-generated method stub

	List<Information> infoList = new ArrayList<Information>();	
	BasicDBObject keys = new BasicDBObject();
	keys.put("_id", 1);
	keys.put("name", 1);
	keys.put("age", 1);

	DBCursor cursor = mongoTemplate.getCollection("information").find(new BasicDBObject(), keys);
	while(cursor.hasNext()){
		Information dbObject = (Information)cursor.next();
		infoList.add(dbObject);
	}
		return null;
	}
    
}
