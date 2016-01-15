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
	public int add(Information generalInfo,int userId) {
		// TODO Auto-generated method stub
	
			generalInfo.setUserId(userId);
			informationDao.save(generalInfo);
			return userId;

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

	public Information query(int userId) {
		// TODO Auto-generated method stub
	
			Query query = Query.query(Criteria.where("userId").is(userId));
			Information information = informationDao.queryOne(query);
			if(information!=null){
			return information;
			}
			else 
				return null;
		
	}

	//更新资料
	public int update(Information information, int userId) {
		// TODO Auto-generated method stub
	
			Query query = Query.query(Criteria.where("userId").is(userId));
		
			Update update = Update.update("address",information.getAddress()).set("height", information.getHeight()).
					set("weight", information.getWeight()).set("sex",information.getSex()).
					set("birthday", information.getBirthday()).
					set("trueName", information.getTrueName());
			informationDao.updateInser(query, update);
			return userId;
	
	}

}
