package com.hengyun.dao.system;

import java.io.InputStream;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.system.AppPackage;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:05:36
* app版本数据操作类
*/
public interface AppPackageDao extends BaseMongodbDao<AppPackage,Integer>{


	//保存文件
	 public void save(InputStream in,String filename);
	 
	 //读出文件
	   public GridFSDBFile getByFileName(String fileName);
}
