package com.hengyun.dao.impl.monitor;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.monitor.ExceptionInfoDao;
import com.hengyun.domain.common.IndexCollection;
import com.hengyun.domain.monitor.ExceptionInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午3:21:14
* 异常信息数据访问层
*/
public class ExceptionInfoDaoImpl extends BaseMongodbDaoImpl<ExceptionInfo,Integer> implements ExceptionInfoDao{

	@Override
	protected Class<ExceptionInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return ExceptionInfo.class;
	}

	@Override
	public int add(ExceptionInfo exceptionInfo) {
		// TODO Auto-generated method stub
		int id=0;
		Query query = Query.query(Criteria.where("exceptionId").gt(0));
        Update update = new Update();
        update.inc("exceptionId", 1);
        IndexCollection index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
		id = index.getExceptionId();
		
		exceptionInfo.setExceptionId(id);;
		this.mongoTemplate.save(exceptionInfo);
		
		return id;
	}

	
}
