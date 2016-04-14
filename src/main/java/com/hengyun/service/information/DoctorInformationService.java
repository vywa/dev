package com.hengyun.service.information;

import java.io.InputStream;

import com.hengyun.domain.account.DoctorInfo;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:26:00
* 类说明
*/
public interface DoctorInformationService extends BaseService<DoctorInfo,Integer>{


	
		public DoctorInfo query(int userId);
	
		public int update(DoctorInfo doctorInfo);
	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
	  
}
