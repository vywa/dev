package com.hengyun.dao.information;

import java.io.File;
import java.io.InputStream;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.information.Icon;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  用户登陆信息
 * */
public interface IconDao extends BaseMongodbDao<Icon,Integer>{

	 public void SaveFile(File file, String fileid, String filename);
	
	   public void save(InputStream in,String filename);
	   
	   public GridFSDBFile getById(Object id);
	   
	   public GridFSDBFile getByFileName(String fileName);
	   
	   
	    // 取出文件
	    public GridFSDBFile retrieveFileOne(String filename); 
	  
}
