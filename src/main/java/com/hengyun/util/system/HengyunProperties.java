package com.hengyun.util.system;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 上午11:12:24
* 属性类
*/
public class HengyunProperties implements Map<String ,String>{
	
	private static final Logger log = LoggerFactory.getLogger(HengyunProperties.class);
	
	private static final String LOAD_PROPERTIES = "query";
	private static final String INSERT_PROPERTIES="save";
	private static final String UPDATE_PROPERTIES="update";
	private static  final String DELETE_PROPERTIES = "delete";
	
	private static HengyunProperties instance = null;
	private Map<String,String> properties;
	
	public static synchronized HengyunProperties getInstance(){
		if(instance == null){
			HengyunProperties props = new HengyunProperties();
			props.init();
			instance = props;
		}
		return instance;
	}

	private HengyunProperties(){}
	
	public void init(){
		if(properties == null) {
			properties = new ConcurrentHashMap<String,String>();
		} else {
			properties.clear();
		}
	
	}
	
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return properties.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return properties.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return properties.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return properties.containsValue(value);
	}

	@Override
	public String get(Object key) {
		// TODO Auto-generated method stub
		return properties.get(key);
	}

	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		// TODO Auto-generated method stub
		for(Map.Entry<? extends String, ? extends String> entry :m.entrySet()){
			
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> values() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableCollection(properties.values());
	}

	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
