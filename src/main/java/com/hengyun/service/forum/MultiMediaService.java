package com.hengyun.service.forum;

import java.io.InputStream;

import com.hengyun.domain.forum.MultiMedia;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

public interface MultiMediaService  extends BaseService<MultiMedia,Integer> {

	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
}
