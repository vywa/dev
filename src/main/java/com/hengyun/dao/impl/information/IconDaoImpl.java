package com.hengyun.dao.impl.information;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.IconDao;
import com.hengyun.domain.information.Icon;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/*
 *  上传文件
 * */

public class IconDaoImpl extends BaseMongodbDaoImpl<Icon,Integer> implements IconDao{

	 private static final Logger log = LoggerFactory.getLogger(IconDaoImpl.class);
	@Override
	protected Class<Icon> getEntityClass() {
		// TODO Auto-generated method stub
		return Icon.class;
	}
	
	

	public void SaveFile(File file, String fileid, String filename) {
		// TODO Auto-generated method stub
		   DB db = mongoTemplate.getDb();
           // 存储fs的根节点
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));
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
           GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));
           GridFSDBFile dbfile = gridFS.findOne(filename);
           if (dbfile != null) {
               return dbfile;
           }
		return null;
	}

	
    public void save(InputStream in,String filename){  
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));

        GridFSInputFile gridFSInputFile =gridFS.createFile(in, filename);  
        gridFSInputFile.save();  
        
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
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));
	
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
    	GridFSDBFile gridFSDBFile = null;
   	    DB db = mongoTemplate.getDb();
     // 存储fs的根节点
      GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));
	
        DBObject query  = new BasicDBObject("filename", fileName);  
  
        	 gridFSDBFile = gridFS.findOne(query);

        return gridFSDBFile;  
    }



	@Override
	public void updateIcon(InputStream in,String filename) {
		// TODO Auto-generated method stub
		Query	query = Query.query(Criteria.where("filename").is(filename));
		
		Icon icon = queryOne(query);
		int id = icon.getId();
		//删除原图片
		this.deleteById(id);
		//修改原图片名
		/*
		 * String oldName = icon.getFilename();
		oldName = oldName+".bank";
		Query	query2 = Query.query(Criteria.where("id").is(id));
		Update update = Update.update("filename", oldName);
	
		this.updateFirst(query2, update);
		*/
		//存储新图片
	    DB db = mongoTemplate.getDb();
	     // 存储fs的根节点
	    GridFS gridFS = new GridFS(db, this.getMongoTemplate().getCollectionName(Icon.class));
		GridFSInputFile gridFSInputFile =gridFS.createFile(in, filename);  
		
	     gridFSInputFile.save();  
	     
	}



	@Override
	public String exist(String filename) {
		// TODO Auto-generated method stub

		Query	query = Query.query(Criteria.where("filename").is(filename));
		Icon icon = queryOne(query);
		if(icon!=null){
		return icon.getFilename();
		}
		else {
			return null;
		}
	}  
    
    
}
