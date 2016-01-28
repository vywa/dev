package com.hengyun.service.impl.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.hengyun.service.shiro.SimpleCacheManager;

public class SimpleCacheManagerImpl implements SimpleCacheManager{

	private MemcachedClient memcachedClient;
	
	public SimpleCacheManagerImpl(MemcachedClient memcachedClient){
		if(memcachedClient == null){
			throw new RuntimeException("必须存在memcached客户端实例");
		}
		this.memcachedClient = memcachedClient;
	}
	
	@Override
	public void createCache(String name, Cache<Object, Object> cache) throws CacheException {
		// TODO Auto-generated method stub
	//	memcachedClient.set(name,0,cache);
	}

	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCache(String name, Cache<Object, Object> cache) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() throws CacheException {
		// TODO Auto-generated method stub
		
	}

}
