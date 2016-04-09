package com.hengyun.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.alibaba.fastjson.JSON;
import com.hengyun.dao.BaseMongodbDao;
import com.mongodb.BasicDBObject;
import com.mongodb.Bytes;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public abstract class BaseMongodbDaoImpl<T extends Serializable, PK extends Serializable> implements BaseMongodbDao<T , PK >{

    @Autowired
    protected MongoTemplate mongoTemplate;

    
    public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
     * 保存一个对象
     *
     * @author bob
     *                
     */
    public void save(T t){
        this.mongoTemplate.save(t);
     
       
    }    
    
    //根据Id从库中查询数据
    public T queryById(PK id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
     
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }
 
    
    //根据条件从库中查询
    public List<T> queryList(Query query){
     
        return this.mongoTemplate.find(query, this.getEntityClass());
    }
    
    //根据条件查询单个记录
    public T queryOne(Query query){
        
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }
    
    //分页查询操作
    public List<T> getPage(Query query, int start, int size){
        query.skip(start);
        query.limit(size);
        
        List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
        return lists;
    }
    
    public Long getPageCount(Query query){
     
        return this.mongoTemplate.count(query, this.getEntityClass());
    }
    
    
    
    //删除对象操作
    public void delete(T t){
      
        this.mongoTemplate.remove(t);
       
    }
    
  //删除操作
    public void delete(Query query){
        this.mongoTemplate.remove(query, this.getEntityClass());
       
    }
    
    //根据ｉｄ删除
    public void deleteById(PK id) {
        Criteria criteria = Criteria.where("_id").in(id);
        if(null!=criteria){
            Query query = new Query(criteria);
          
            if(null!=query && this.queryOne(query)!=null){
            	
              this.mongoTemplate.remove(query, this.getEntityClass());
            }
        }
    }
    
  
    //修改满足条件的一条记录
    public void updateFirst(Query query,Update update){
   
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }
    
    //修改满足条件的多条记录
    public void updateMulti(Query query, Update update){
  
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }
    
    //修改，如果满足条件对象不存在则添加
    public void updateInser(Query query, Update update){
      
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }
    

  
  
    
    //钩子方法，由子类实现返回反射对象的类型
    protected abstract Class<T> getEntityClass();
   
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
}
