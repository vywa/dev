package com.hengyun.service.information;

import java.io.InputStream;

import com.hengyun.domain.account.AdminInfo;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:25:45
* 类说明
*/
public interface AdminInformationService extends BaseService<AdminInfo,Integer>{

	
	public int add(AdminInfo adminInfo,int userId);
	
		public AdminInfo query(int userId);
	
	public int update(AdminInfo adminInfo ,int userId);
	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
}
