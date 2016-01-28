package com.hengyun.service.impl.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import com.hengyun.service.shiro.SimpleCacheManager;

/*
 *  安全框架缓存管理器实现类
 * */
public class ShiroCacheManager implements CacheManager,Destroyable{

	private SimpleCacheManager simpleCacheManager;

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		simpleCacheManager.destroy();
	}

	@Override
	public Cache<Object ,Object> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		
		return simpleCacheManager.getCache(name);
	}

	public SimpleCacheManager getSimpleCacheManager() {
		return simpleCacheManager;
	}

	public void setSimpleCacheManager(SimpleCacheManager simpleCacheManager) {
		this.simpleCacheManager = simpleCacheManager;
	}
	
	
}
