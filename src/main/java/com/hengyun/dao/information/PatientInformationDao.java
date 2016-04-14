package com.hengyun.dao.information;

import java.io.File;
import java.io.InputStream;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.account.PatientInfo;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:09:04
* 类说明
*/
public interface PatientInformationDao extends BaseMongodbDao<PatientInfo,Integer>{

	 public void SaveFile(File file, String fileid, String filename);
		
	   public void save(InputStream in,String filename);
	   
	   public GridFSDBFile getById(Object id);
	   
	   public GridFSDBFile getByFileName(String fileName);
	   
	   
	    // 取出文件
	    public GridFSDBFile retrieveFileOne(String filename); 
}
