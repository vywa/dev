package com.hengyun.service.information;

import java.io.InputStream;


import com.hengyun.domain.information.Information;

import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

public interface InformationService  extends BaseService<Information,Integer> {

	public int add(Information generalInfo,String tocken);
	
	public Information query(String tocken);
	
	public int update(Information information ,String tocken);
	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
}
