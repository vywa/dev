package com.hengyun.service.monitor;

import java.util.List;

import com.hengyun.domain.monitor.ExceptionInfo;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午3:26:10
* 异常信息业务访问层
*/
public interface ExceptionInfoService extends BaseService<ExceptionInfo,Integer>{

	/*
	 *  添加异常信息
	 * */
	public void add(ExceptionInfo exceptionInfo);
	
	
	/*
	 *  查询异常信息
	 * */
	public List<ExceptionInfo> query(String ip);
	
	
	/*
	 *  删除异常信息
	 * */
	public void del(ExceptionInfo exceptionInfo);
	
	
}
