package com.hengyun.dao.impl.information;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.PatientInformationDao;
import com.hengyun.domain.account.PatientInfo;
import com.hengyun.domain.information.Information;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;



/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:15:52
* 类说明
*/
public class PatientInformationDaoImpl extends BaseMongodbDaoImpl<PatientInfo,Integer> implements PatientInformationDao{

	private static final Logger log = LoggerFactory.getLogger(PatientInformationDaoImpl.class);
	@Override
	protected Class<PatientInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return PatientInfo.class;
	}

	public void SaveFile(File file, String fileid, String filename) {
		// TODO Auto-generated method stub
		   DB db = mongoTemplate.getDb();
           // 存储fs的根节点
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(PatientInfo.class));
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
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(PatientInfo.class));
           GridFSDBFile dbfile = gridFS.findOne(filename);
           if (dbfile != null) {
               return dbfile;
           }
		return null;
	}

	
    public void save(InputStream in,String filename){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(PatientInfo.class));

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
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(PatientInfo.class));
	
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
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(PatientInfo.class));
	
        DBObject query  = new BasicDBObject("filename", fileName);  
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);  
        log.info("read file "+fileName+"success");
        return gridFSDBFile;  
    }  
    
}
