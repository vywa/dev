package com.hengyun.service.impl.information;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.information.Information;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  　个人信息管理
 * */

public class InformationServiceImpl extends BaseServiceImpl<Information,Integer> implements InformationService{

	@Resource 
	private InformationDao informationDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	//添加资料
	public int add(Information generalInfo,String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			generalInfo.setUserId(userId);
		informationDao.save(generalInfo);
			return 0;
		} 
		return -1;
	}
	
	//保存文件
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		this.save(in, filename);
	}
	
	//下载文件
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return this.retrieveFileOne(filename);
	}

	public Information query(String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Query query = Query.query(Criteria.where("userId").is(userId));
			Information information = informationDao.queryOne(query);
			return information;
		} 
		return null;
	}

	//更新资料
	public int update(Information information, String tocken) {
		// TODO Auto-generated method stub
		int userId = loginInfoService.isOnline(tocken);
		if(userId>0){
			Query query = Query.query(Criteria.where("userId").is(userId));
			Update update = Update.update("age", 50).set("height", information.getHeight()).
					set("weight", information.getWeight()).set("gender",information.getGender()).set("age", information.getAge());
			informationDao.updateFirst(query, update);
			return 0;
		} 
			return -1;
	
	}

}
