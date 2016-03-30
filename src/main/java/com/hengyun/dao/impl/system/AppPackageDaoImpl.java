package com.hengyun.dao.impl.system;

import java.io.InputStream;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.system.AppPackageDao;
import com.hengyun.domain.forum.MultiMedia;
import com.hengyun.domain.system.AppPackage;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:07:19
* app版本数据访问
*/
public class AppPackageDaoImpl extends BaseMongodbDaoImpl<AppPackage,Integer> implements AppPackageDao{

	@Override
	protected Class<AppPackage> getEntityClass() {
		// TODO Auto-generated method stub
		return AppPackage.class;
	}

	  public void save(InputStream in,String filename){  
	   	    DB db = mongoTemplate.getDb();
	     // 存储fs的根节点
	      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AppPackage.class));
	        GridFSInputFile gridFSInputFile =gridFS.createFile(in, filename);  
	      
	        gridFSInputFile.save();  
	        
	        return;  
	    }  
		
		
	       
	    /** 
	     * 据文件名返回文件，只返回第一个 
	     *
	     */  
	    public GridFSDBFile getByFileName(String fileName){  
	   	    DB db = mongoTemplate.getDb();
	     // 存储fs的根节点
	      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AppPackage.class));
		
	        DBObject query  = new BasicDBObject("filename", fileName);  
	        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
	        return gridFSDBFile;  
	    }  
	    
}
