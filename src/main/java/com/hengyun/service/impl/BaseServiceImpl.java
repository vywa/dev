package com.hengyun.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.BaseMongodbDao;
import com.hengyun.service.BaseService;


public class BaseServiceImpl<T extends Serializable, PK extends Serializable> implements BaseService<T, PK> {

	protected BaseMongodbDao<T, PK> baseMongodbDao;
	
	
	public BaseMongodbDao<T, PK> getBaseMongodbDao() {
		return baseMongodbDao;
	}

	//需要依赖注入
	public void setBaseMongodbDao(BaseMongodbDao<T, PK> baseMongodbDao) {
		this.baseMongodbDao = baseMongodbDao;
	}


	public void save(T t) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().save(t);
		
	}

	
	public T queryById(PK id) {
		// TODO Auto-generated method stub
		return this.getBaseMongodbDao().queryById(id);
	}

	
	public List<T> queryList(Query query) {
		// TODO Auto-generated method stub
		return this.getBaseMongodbDao().queryList(query);
	}

	
	public T queryOne(Query query) {
		// TODO Auto-generated method stub
		return this.getBaseMongodbDao().queryOne(query);
	}

	
	public List<T> getPage(Query query, int start, int size) {
		// TODO Auto-generated method stub
		return this.getBaseMongodbDao().getPage(query, start, size);
	}

	
	public Long getPageCount(Query query) {
		// TODO Auto-generated method stub
		return this.getBaseMongodbDao().getPageCount(query);
	}

	
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().delete(t);
	}

	
	public void deleteById(PK id) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().deleteById(id);
	}

	
	public void updateFirst(Query query, Update update) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().updateFirst(query, update);
	}

	
	public void updateMulti(Query query, Update update) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().updateMulti(query, update);
	}


	public void updateInser(Query query, Update update) {
		// TODO Auto-generated method stub
		this.getBaseMongodbDao().updateInser(query, update);
	}

}
