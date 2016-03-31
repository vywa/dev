package com.hengyun.service.information;

import java.io.InputStream;
import java.util.List;

import com.hengyun.domain.information.Information;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

public interface InformationService  extends BaseService<Information,Integer> {

	public int add(Information information,int userId);
	
	
	
	public Information query(int userId);
	
	public int update(Information information ,int userId);
	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
}
