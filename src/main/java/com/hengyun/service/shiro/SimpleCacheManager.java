package com.hengyun.service.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/*
 *  缓存管理器接口
 * */
public interface SimpleCacheManager {

	/*
	 *  新增缓存堆到管理器
	 * */
	
	public abstract void createCache(String name, Cache<Object,Object> cache) throws CacheException;
	
	/*
	 *  获取缓存堆
	 * */
	public abstract Cache<Object,Object> getCache(String name) throws CacheException;
	
	/*
	 *  移除缓存堆
	 * */
	public abstract void removeCache(String name) throws CacheException;
	/*
	 *  更新缓存堆
	 * */
	public abstract void updateCache(String name ,Cache<Object,Object> cache) throws CacheException;
	
	/*
	 *  注销缓存堆
	 * */
	
	public abstract void destroy() throws CacheException;
}
