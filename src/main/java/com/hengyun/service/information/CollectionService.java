package com.hengyun.service.information;

import java.util.List;

import com.hengyun.domain.information.Collection;
import com.hengyun.domain.information.DailyNewsCollection;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:30:08
* 类说明
*/
public interface CollectionService  extends BaseService<Collection,Integer>{

	/*
	 * 
	 * 	添加收藏
	 * 
	 * */
	
	public void addCollection(DailyNewsCollection dailyNewsCollection,int userId,int type);
	
	/*
	 * 
	 *  	查看收藏列表
	 * 
	 * */
	public Collection show(int userId);
	
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
	public void delete(int userId,int id,int type);
	
}
