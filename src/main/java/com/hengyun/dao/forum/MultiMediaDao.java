package com.hengyun.dao.forum;

import java.io.InputStream;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.forum.MultiMedia;
import com.mongodb.gridfs.GridFSDBFile;

/*
 * 权限数据访问层
 * */
public interface MultiMediaDao extends BaseMongodbDao<MultiMedia,Integer>{

	//保存文件
	 public void save(InputStream in,String filename);
	 
	 //读出文件
	   public GridFSDBFile getById(Object id);
	   
	   public GridFSDBFile getByFileName(String fileName);
	
}
