package com.hengyun.service.impl.information;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.forum.SubjectDao;
import com.hengyun.dao.information.CollectionDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.notice.DailyNewsDao;
import com.hengyun.domain.information.Collection;
import com.hengyun.domain.information.DailyNewsCollection;
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
	
	@Resource
	private SubjectDao subjectDao;
	
	@Resource
	private DailyNewsDao dailyNewsDao;
	
	/*
	 * 
	 * 	添加收藏
	 * 
	 * */
	public int addCollection(DailyNewsCollection dailyNewsCollection,int userId,int type){
		int id = indexCollectionDao.updateIndex("collectionId");
		dailyNewsCollection.setCollectionId(id); 				//收藏id
		dailyNewsCollection.setCollectionTime(new Date());
		dailyNewsCollection.setType(type);
		
		Query query = Query.query(Criteria.where("userId").is(userId));
		Collection collection = collectionDao.queryOne(query);
		if(collection==null){
			collection = new Collection();
			collection.setUserId(userId);
			collectionDao.save(collection);
		}
		switch(type){
		case 0:
			List<DailyNewsCollection> subjectList = collection.getSubjectList();
			if(subjectList == null){
				subjectList = new ArrayList<DailyNewsCollection>();
			}else {
				for(DailyNewsCollection temp :subjectList){
					if(temp.getId()==dailyNewsCollection.getId()){
						return -1;
					}
				}
			}
			subjectList.add(dailyNewsCollection);
			Update update = Update.update("subjectList", subjectList);
			collectionDao.updateFirst(query, update);
			break;
		case 1:
			List<DailyNewsCollection> dailyNewsList = collection.getDailyNewsList();
			if(dailyNewsList == null){
				dailyNewsList = new ArrayList<DailyNewsCollection>();
			}else {
				for(DailyNewsCollection temp :dailyNewsList){
					if(temp.getId()==dailyNewsCollection.getId()){
						return -1;
					}
				}
			}
			dailyNewsList.add(dailyNewsCollection);
			Update update2 = Update.update("dailyNewsList", dailyNewsList);
			collectionDao.updateFirst(query, update2);
			break;
		case 2:
			List<DailyNewsCollection> imCollection = collection.getImCollection();
			if(imCollection == null){
				imCollection = new ArrayList<DailyNewsCollection>();
			}else {
				for(DailyNewsCollection temp :imCollection){
					if(temp.getId()==dailyNewsCollection.getId()){
						return -1;
					}
				}
			}
			imCollection.add(dailyNewsCollection);
			Update update3 = Update.update("imCollection", imCollection);
			collectionDao.updateFirst(query, update3);
			break;
		default:
			break;
		
		}
		return id;
	}
	
	/*
	 * 
	 *  	查看收藏列表
	 * 
	 * */
	public Collection show(int userId){
		Query query = Query.query(Criteria.where("userId").is(userId));
		Collection coll = collectionDao.queryOne(query);
		return coll;
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
	public void delete(int userId,int id,int type){
		Query query = Query.query(Criteria.where("userId").is(userId));
		Collection coll = collectionDao.queryOne(query);
		switch(type){
		case 0:
			List<DailyNewsCollection> subjectList = coll.getSubjectList();
			CopyOnWriteArrayList<DailyNewsCollection> list = new CopyOnWriteArrayList<DailyNewsCollection>(subjectList); 
			for(DailyNewsCollection temp:list){
				if(temp.getId()==id){
					list.remove(temp);
				}
			}
			Update update = Update.update("subjectList", list);
			collectionDao.updateFirst(query, update);
		
			break;
		case 1:
			List<DailyNewsCollection> dailyNewsList = coll.getDailyNewsList();
			CopyOnWriteArrayList<DailyNewsCollection> list1 = new CopyOnWriteArrayList<DailyNewsCollection>(dailyNewsList); 
			for(DailyNewsCollection temp:list1){
				if(temp.getId()==id){
					list1.remove(temp);
				}
			}
			Update update2 = Update.update("dailyNewsList", list1);
			collectionDao.updateFirst(query, update2);
			break;
		case 2:
			List<DailyNewsCollection> imCollection = coll.getImCollection();
			CopyOnWriteArrayList<DailyNewsCollection> list2 = new CopyOnWriteArrayList<DailyNewsCollection>(imCollection); 
			for(DailyNewsCollection temp:list2){
				if(temp.getId()==id){
					list2.remove(temp);
				}
			}
			Update update3 = Update.update("imCollection", list2);
			collectionDao.updateFirst(query, update3);
			break;
		default:break;
		}
	
		
	}

	
}
