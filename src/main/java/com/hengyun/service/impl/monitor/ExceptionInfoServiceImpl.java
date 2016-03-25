package com.hengyun.service.impl.monitor;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.monitor.ExceptionInfoDao;
import com.hengyun.domain.monitor.ExceptionInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.monitor.ExceptionInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午3:27:32
* 异常信息业务层
*/
public class ExceptionInfoServiceImpl extends BaseServiceImpl<ExceptionInfo,Integer> implements ExceptionInfoService{

	private static final Logger log = LoggerFactory.getLogger(ExceptionInfoServiceImpl.class);
	
	@Resource
	private ExceptionInfoDao exceptionInfoDao;
	
	/*
	 *  添加异常信息
	 * */
	@Override
	public void add(ExceptionInfo exceptionInfo) {
		// TODO Auto-generated method stub
		exceptionInfoDao.add(exceptionInfo);
	}

	/*
	 *  查询异常信息
	 * */
	@Override
	public List<ExceptionInfo> query(String ip) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("ip").is(ip));
		
		List<ExceptionInfo> exceptionInfoList = exceptionInfoDao.queryList(query);
		return exceptionInfoList;
	}

	
	/*
	 *  删除异常信息
	 * */
	@Override
	public void del(ExceptionInfo exceptionInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("ip").is(exceptionInfo.getIp()));
		exceptionInfoDao.delete(query);
	}

	
	
}
