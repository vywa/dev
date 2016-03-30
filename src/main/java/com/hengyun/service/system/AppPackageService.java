package com.hengyun.service.system;

import java.io.InputStream;
import java.util.List;

import com.hengyun.domain.system.AppPackage;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:14:25
* app版本业务接口
*/
public interface AppPackageService extends BaseService<AppPackage,Integer> {

  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
	  
	  /*
	   *  查询列表
	   * */
	  public List<AppPackage> queyList();
}
