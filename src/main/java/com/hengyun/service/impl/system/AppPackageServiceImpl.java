package com.hengyun.service.impl.system;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.system.AppPackageDao;
import com.hengyun.domain.system.AppPackage;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.system.AppPackageService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:15:41
* app版本管理业务实现类
*/
public class AppPackageServiceImpl extends BaseServiceImpl<AppPackage,Integer> implements AppPackageService{

	@Resource
	private AppPackageDao appPackageDao;


	//保存文件
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		appPackageDao.save(in, filename);
	}
	
	//下载文件
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return appPackageDao.getByFileName(filename);
	}

	/*
	 *  获取列表
	 * */
	@Override
	public List<AppPackage> queyList() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("appName").exists(true));
		List<AppPackage> list = appPackageDao.queryList(query);
		return list;
	}


}
