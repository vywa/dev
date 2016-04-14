package com.hengyun.service.impl.information;

import java.io.InputStream;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.dao.information.AdminInformationDao;
import com.hengyun.domain.account.AdminInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.AdminInformationService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:34:10
* 类说明
*/
public class AdminInformationServiceImpl extends BaseServiceImpl<AdminInfo,Integer> implements AdminInformationService{

	 private static final Logger log = LoggerFactory.getLogger(AdminInformationServiceImpl.class);
	 
	@Resource
	private AdminInformationDao adminInformationDao;
	
	@Override
	public int add(AdminInfo adminInfo, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminInfo query(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(AdminInfo adminInfo, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

}
