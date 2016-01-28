package com.hengyun.service.impl.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.CSS.Attribute;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/*
 *  缓存实现类，实现序列接口，方便对象存储于第三方容器
 * */

public class SimpleMapCache implements Cache<Object,Object>, Serializable{
	
	private final Map<Object,Object> attributes;
	private final String name;
	

	public SimpleMapCache(Map<Object, Object> backingMap, String name) {
		if(name == null){
			throw new IllegalArgumentException("Cache name can't be null");
		} 
		if(backingMap == null){
			throw new IllegalArgumentException("Backing map can't be null");
		} else {
			this.name = name;
			attributes= backingMap;
			
		}
	}

		
	
	
	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
		attributes.clear();
	}

	@Override
	public Object get(Object key) throws CacheException {
		// TODO Auto-generated method stub
		
		return attributes.get(key);
	}

	@Override
	public Set<Object> keys() {
		// TODO Auto-generated method stub
		Set<Object> keys = attributes.keySet();
		if(!keys.isEmpty()){
			return Collections.unmodifiableSet(keys);
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public Object put(Object key, Object value) throws CacheException {
		// TODO Auto-generated method stub
		
		return attributes.put(key, value);
	}

	@Override
	public Object remove(Object key) throws CacheException {
		// TODO Auto-generated method stub
		return attributes.remove(key);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return attributes.size();
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimpleMapCache ");
		return builder.toString();
	}

	
}
