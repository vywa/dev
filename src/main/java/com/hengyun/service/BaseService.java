package com.hengyun.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface BaseService<T extends Serializable, PK extends Serializable> {
	
	 public void save(T t);
	//根据Id从库中查询数据
	    public T queryById(PK id) ;
	  //根据条件从库中查询
	    public List<T> queryList(Query query);
	    //根据条件查询单个记录
	    public T queryOne(Query query);
	    //分页查询操作
	    public List<T> getPage(Query query, int start, int size);
	    //获取总的记录页数
	    public Long getPageCount(Query query);
	  //删除对象操作
	    public void delete(T t);
	    //根据ｉｄ删除
	    public void deleteById(PK id) ;
	    //修改满足条件的一条记录
	    public void updateFirst(Query query,Update update);
	    //修改满足条件的多条记录
	    public void updateMulti(Query query, Update update);
	    //修改，如果满足条件对象不存在则添加
	    public void updateInser(Query query, Update update);
	    
	      
}