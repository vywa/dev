package com.hengyun.service.impl.information;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.information.CollectionDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.information.Collection;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.CollectionService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:32:11
* 收藏业务实现类
*/
public class CollectionServiceImpl extends BaseServiceImpl<Collection,Integer> implements CollectionService{

	private static final Logger log = LoggerFactory.getLogger(CollectionServiceImpl.class);
	
	@Resource
	private CollectionDao collectionDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	/*
	 * 
	 * 	添加收藏
	 * 
	 * */
	public void addCollection(Collection collection){
		int id = indexCollectionDao.updateIndex("collectionId");
		collection.setId(id);
		collection.setCollectionTime(new Date());
		collectionDao.save(collection);
	}
	
	/*
	 * 
	 *  	查看收藏列表
	 * 
	 * */
	public List<Collection> show(int userId){
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<Collection> list = collectionDao.queryList(query);
		if(list == null){
			return null;
		} else {
			return list;
		}
		
	}
	
	/*
	 * 
	 *  	查看某个收藏详情
	 * 
	 * */
	//public Collection getCollection(String url);
	
	/*
	 * 
	 *  删除收藏
	 * 
	 * */
	public void delete(int id){
		Query query = Query.query(Criteria.where("id").is(id));
		collectionDao.delete(query);
		
		
	}
}
