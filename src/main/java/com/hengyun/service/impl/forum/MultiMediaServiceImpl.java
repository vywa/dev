package com.hengyun.service.impl.forum;

import java.io.InputStream;

import javax.annotation.Resource;

import com.hengyun.dao.forum.MultiMediaDao;
import com.hengyun.domain.forum.MultiMedia;
import com.hengyun.service.forum.MultiMediaService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  　个人信息管理
 * */

public class MultiMediaServiceImpl extends BaseServiceImpl<MultiMedia,Integer> implements MultiMediaService{

	@Resource 
	private MultiMediaDao multiMediaDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	
	
	//保存文件
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		multiMediaDao.save(in, filename);
	}
	
	//下载文件
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return multiMediaDao.getByFileName(filename);
	}


}
