package com.hengyun.dao.monitor;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.domain.monitor.ExceptionInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午3:16:18
* 异常信息数据记录
*/
public interface ExceptionInfoDao extends BaseMongodbDao<ExceptionInfo,Integer>{

	public int add(ExceptionInfo exceptionInfo);
}
