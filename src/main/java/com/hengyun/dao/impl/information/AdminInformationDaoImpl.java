package com.hengyun.dao.impl.information;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.AdminInformationDao;
import com.hengyun.domain.account.AdminInfo;
import com.hengyun.domain.account.DoctorInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:15:31
* 类说明
*/
public class AdminInformationDaoImpl extends BaseMongodbDaoImpl<AdminInfo,Integer> implements AdminInformationDao{

	private static final Logger log = LoggerFactory.getLogger(AdminInformationDaoImpl.class);
	
	@Override
	protected Class<AdminInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return AdminInfo.class;
	}

	@Override
	public void SaveFile(File file, String fileid, String filename) {
		// TODO Auto-generated method stub
		   DB db = mongoTemplate.getDb();
           // 存储fs的根节点
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AdminInfo.class));
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
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AdminInfo.class));
           GridFSDBFile dbfile = gridFS.findOne(filename);
           if (dbfile != null) {
               return dbfile;
           }
		return null;
	}

	
    public void save(InputStream in,String filename){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AdminInfo.class));

        GridFSInputFile gridFSInputFile =gridFS.createFile(in, "filename");  
        gridFSInputFile.save();  
        log.info("save  file "+filename+"success");
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
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AdminInfo.class));
	
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
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(AdminInfo.class));
	
        DBObject query  = new BasicDBObject("filename", fileName);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        log.info("read file "+fileName+"success");
        return gridFSDBFile;  
    }  
	
}
